package utilities;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import be.quodlibet.boxable.BaseTable;
import be.quodlibet.boxable.Cell;
import be.quodlibet.boxable.Row;


public class CPdf {
	/**
	 * variables de control de tama�o de celdas
	 * */
	
	private float celda_a=21;
	private float celda_b=(float)6.7;
	private float celda_c=6;
	private float font_size=7f;
	/*
	 * variables de texto
	 * */
	private String titulo ="";
	private String anio="";
	private int numero_columnas=13;
	/**
	 * Variables del documento
	 */
	private PDDocument doc;
	private PDPage page;
	
	
		public CPdf(String titulo){
			this.titulo=titulo;
			doc = new PDDocument();
			page = new PDPage(new PDRectangle(PDRectangle.LETTER.getHeight(), PDRectangle.LETTER.getWidth()));
		    doc.addPage( page );
		}
		public String ExportPdf(String [][]headers, String [][]datosMetas, int visualizacion){
			String path = "";
			try{	
			    String [] cabeceras = new String[headers[0].length];
			    System.arraycopy( headers[0], 0, cabeceras, 0, headers[0].length );;
			   
			    PDPageContentStream contentStream = new PDPageContentStream(doc, page);

				// Define a text content stream using the selected font, moving the cursor and drawing the text "Hello World"
				PDFont font = PDType1Font.HELVETICA_BOLD;
				
				contentStream.beginText();
				contentStream.setFont(font, 18);
				//definir x, y
				contentStream.newLineAtOffset(50, 550);
				contentStream.showText("Ministerio de Finanzas P�blicas");
				contentStream.endText();
				
				contentStream.beginText();
				contentStream.setFont(font, 12);
				//definir x, y
				contentStream.newLineAtOffset(50, 530);
				contentStream.showText("Reporte: "+titulo);
				contentStream.endText();
				
				float margin = 50;
				float yStartNewPage = page.getMediaBox().getHeight() - (2 * margin);
				float tableWidth = page.getMediaBox().getWidth() - (2 * margin);

				boolean drawContent = true;
				float yStart = yStartNewPage;
				float bottomMargin = 70;
				// y position is your coordinate of top left corner of the table
				float yPosition = 525;

				/*BaseTable table = new BaseTable(525, yStartNewPage, bottomMargin, tableWidth, margin, doc, page, true, drawContent);
				table.addHeaderRow(agregarCabecera(table,cabeceras));*/
				String [][]cabeceras_fixed= configurarCabeceras(cabeceras,datosMetas[0]);
				List <String[][]>tablas =divTablas(cabeceras_fixed,datosMetas,visualizacion);
				System.out.println(tablas.size()+"  -tablas");
				for(int x=0;x<tablas.size();x++){
					String[][] tabla_tmp = tablas.get(x);
					BaseTable table_x= new BaseTable(525, yStartNewPage, bottomMargin, tableWidth, margin, doc, page, true, drawContent);
					boolean ultimo=x==tablas.size()-1;
					table_x.addHeaderRow(agregarCabecera(table_x,tabla_tmp[0],x,ultimo,visualizacion));
					table_x.draw();
				}
				
				
				/**
				 * creando la segunda fila de encabezado
				 */
				//creando fila
				/*Row<PDPage> row = table.createRow(12);
				row= agregarCabecera_pt2(row, datosMetas[0]);
				table.setTableIsBroken(true);
				table.addHeaderRow(row);
				
				for(int i=0; i<datosMetas.length;i++){
					row= agregarFila(table,datosMetas[i]);
				}*/
				//table.draw();
			    contentStream.close();
			    path = String.join("","/archivos/temporales/temp_",((Long) new Date().getTime()).toString(),".pdf");
				FileOutputStream out = new FileOutputStream(new File(path));
				doc.save(out);
				doc.close();
			}catch(Exception o){
				o.printStackTrace();
			}
			return path;
		}
		
		public Row<PDPage> agregarFila(BaseTable table, String []datos){
			Row<PDPage> row = table.createRow(12);			
			for(int i=0;i<datos.length;i++){
				String texto="";
				if(datos[i]==null||datos[i].isEmpty()){
					texto="";
				}else{
					texto=datos[i];
				}
				if(i==0){
					Cell<PDPage> cell = row.createCell(celda_a, texto);
					cell.setFontSize(font_size);
				}else if(i==1){
					Cell<PDPage>cell = row.createCell(celda_c, texto);
					cell.setFontSize(font_size);
				}else{
					Cell<PDPage> cell = row.createCell(celda_b, texto);
					cell.setFontSize(font_size);
				}
			}
			return row;
		}
		
		public Row<PDPage> agregarCabecera(BaseTable table,String cabecera[], int posicion, boolean ultimo, int visualizacion){
			Row<PDPage> headerRow = table.createRow(12);
			int corrimiento=0;
			float tam_celda=celda_b;
			Cell<PDPage> cell;
			if(visualizacion==2){
				tam_celda=tam_celda*2;
			}
			if(posicion==0){
				corrimiento=2;
				cell = headerRow.createCell(celda_a, "");
				cell = headerRow.createCell(celda_c, "");	
			}			
			cell = headerRow.createCell(celda_c, "");	
			cell.setHeaderCell(true);
			for(int i =corrimiento; i<cabecera.length-1;i++){
				if(cabecera[i]!=null&& !cabecera[i].isEmpty()){
					cell = headerRow.createCell(tam_celda, cabecera[i]);
					cell.setHeaderCell(true);
				}
			}
			if(ultimo){
				cell = headerRow.createCell(celda_b, "");
				cell.setHeaderCell(true);
			}
				
			return headerRow;
			
		}
		public Row<PDPage> agregarCabecera_pt2(Row<PDPage> row,String cabecera[]){
			//System.out.println(cabecera.length);
			Cell<PDPage> cell = row.createCell(celda_a, "Nombre");
			cell.setFontSize(cell.getFontSize()-1f);
			cell = row.createCell(celda_c,"Meta Unidad Medida");	
			cell.setFontSize(cell.getFontSize()-1f);
			int control =1;
			for(int i =0; i<cabecera.length-3;i++){
				if(control==2){
					control=1;
					cell = row.createCell(celda_b, "Real");
					cell.setFontSize(cell.getFontSize()-1f);
				}else{
					control++;
					cell = row.createCell(celda_b, "Planificado");
					cell.setFontSize(cell.getFontSize()-1f);
				}
			}
			
			cell = row.createCell(celda_b, "Meta Final");
			cell.setFontSize(cell.getFontSize()-1f);
			
			return row;
			
		}
		
		
		
		private String[][] configurarCabeceras(String []cabecera, String []subcabecera){
			String [][]ret=new String [2][subcabecera.length];
			//primera l�nea.
			ret[0][0]=" ";
			ret[0][1]=" ";
			int cont=2;
			for(int i =2; i<cabecera.length-1;i++){
				if(!cabecera[i].isEmpty()&&cabecera[i].compareTo("null")!=0){
					ret[0][cont]=cabecera[i];
					cont++;
				}
			}
			ret[1][0]="Nombre";
			ret[1][1]="Meta Unidad Medida";
			int control =1;
			//segunda l�nea
			for(int i =0; i<subcabecera.length-3;i++){
				cont=i;
				if(control==2){
					control=1;
					ret[1][i+2]="Real";
				}else{
					control++;
					ret[1][i+2]="Planificado";
				}
			}
			ret[1][ret[1].length-1]="Meta Final";
			return ret;
		}
		
		private List<String[][]> divTablas(String[][]cabecera, String[][]datos, int visualizacion){
			List <String[][]>ret  = new ArrayList<String[][]>();
			int totalFilas= cabecera.length+datos.length;
			if(visualizacion==2){
				int num = (int)Math.ceil(
						((datos[0].length-3)/10)+((datos[0].length-3)% 10)*0.1
						);
				int num_col_data=datos[0].length;
				try{
					for(int x=0; x<num; x++){
						String [][] tabla_tmp= new String[totalFilas][12];
						int medida= x<num-1? 12: num_col_data-(12*x);
						int tam_cab= x==0? 7: 6;
						int pos_cab= x==1? 7: 6;
						for(int y=0; y<totalFilas;y++){
							if(y==0){
								System.arraycopy(cabecera[y], pos_cab*x, tabla_tmp[y], 0, tam_cab);
							}else if(y==1){
								System.arraycopy(cabecera[y], 12*x, tabla_tmp[y], 0, medida);
							}else{
								System.arraycopy( datos[y-2], 12*x, tabla_tmp[y], 0, medida);
							}
						}
						ret.add(tabla_tmp);
					}
					
				}catch(Exception o){
					o.printStackTrace();
				}
				
			}
			return ret;
		}
}
