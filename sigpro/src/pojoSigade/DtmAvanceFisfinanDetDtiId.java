package pojoSigade;
// Generated May 16, 2017 12:50:34 PM by Hibernate Tools 5.2.1.Final

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * DtmAvanceFisfinanDetDtiId generated by hbm2java
 */
@Embeddable
public class DtmAvanceFisfinanDetDtiId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 166199601931621160L;
	private BigDecimal ejercicioFiscal;
	private String mesDesembolso;
	private String codigoPresupuestario;
	private int entidadSicoin;
	private int unidadEjecutoraSicoin;
	private String monedaDesembolso;
	private BigDecimal desembolsosMesMoneda;
	private BigDecimal tcMonUsd;
	private BigDecimal desembolsosMesUsd;
	private BigDecimal tcUsdGtq;
	private BigDecimal desembolsosMesGtq;

	public DtmAvanceFisfinanDetDtiId() {
	}

	public DtmAvanceFisfinanDetDtiId(String mesDesembolso, String codigoPresupuestario, int entidadSicoin,
			int unidadEjecutoraSicoin, String monedaDesembolso, BigDecimal desembolsosMesMoneda, BigDecimal tcMonUsd,
			BigDecimal desembolsosMesUsd, BigDecimal tcUsdGtq, BigDecimal desembolsosMesGtq) {
		this.mesDesembolso = mesDesembolso;
		this.codigoPresupuestario = codigoPresupuestario;
		this.entidadSicoin = entidadSicoin;
		this.unidadEjecutoraSicoin = unidadEjecutoraSicoin;
		this.monedaDesembolso = monedaDesembolso;
		this.desembolsosMesMoneda = desembolsosMesMoneda;
		this.tcMonUsd = tcMonUsd;
		this.desembolsosMesUsd = desembolsosMesUsd;
		this.tcUsdGtq = tcUsdGtq;
		this.desembolsosMesGtq = desembolsosMesGtq;
	}

	public DtmAvanceFisfinanDetDtiId(BigDecimal ejercicioFiscal, String mesDesembolso, String codigoPresupuestario,
			int entidadSicoin, int unidadEjecutoraSicoin, String monedaDesembolso, BigDecimal desembolsosMesMoneda,
			BigDecimal tcMonUsd, BigDecimal desembolsosMesUsd, BigDecimal tcUsdGtq, BigDecimal desembolsosMesGtq) {
		this.ejercicioFiscal = ejercicioFiscal;
		this.mesDesembolso = mesDesembolso;
		this.codigoPresupuestario = codigoPresupuestario;
		this.entidadSicoin = entidadSicoin;
		this.unidadEjecutoraSicoin = unidadEjecutoraSicoin;
		this.monedaDesembolso = monedaDesembolso;
		this.desembolsosMesMoneda = desembolsosMesMoneda;
		this.tcMonUsd = tcMonUsd;
		this.desembolsosMesUsd = desembolsosMesUsd;
		this.tcUsdGtq = tcUsdGtq;
		this.desembolsosMesGtq = desembolsosMesGtq;
	}

	@Column(name = "EJERCICIO_FISCAL", precision = 22, scale = 0)
	public BigDecimal getEjercicioFiscal() {
		return this.ejercicioFiscal;
	}

	public void setEjercicioFiscal(BigDecimal ejercicioFiscal) {
		this.ejercicioFiscal = ejercicioFiscal;
	}

	@Column(name = "MES_DESEMBOLSO", nullable = false, length = 2)
	public String getMesDesembolso() {
		return this.mesDesembolso;
	}

	public void setMesDesembolso(String mesDesembolso) {
		this.mesDesembolso = mesDesembolso;
	}

	@Column(name = "CODIGO_PRESUPUESTARIO", nullable = false, length = 12)
	public String getCodigoPresupuestario() {
		return this.codigoPresupuestario;
	}

	public void setCodigoPresupuestario(String codigoPresupuestario) {
		this.codigoPresupuestario = codigoPresupuestario;
	}

	@Column(name = "ENTIDAD_SICOIN", nullable = false, precision = 8, scale = 0)
	public int getEntidadSicoin() {
		return this.entidadSicoin;
	}

	public void setEntidadSicoin(int entidadSicoin) {
		this.entidadSicoin = entidadSicoin;
	}

	@Column(name = "UNIDAD_EJECUTORA_SICOIN", nullable = false, precision = 6, scale = 0)
	public int getUnidadEjecutoraSicoin() {
		return this.unidadEjecutoraSicoin;
	}

	public void setUnidadEjecutoraSicoin(int unidadEjecutoraSicoin) {
		this.unidadEjecutoraSicoin = unidadEjecutoraSicoin;
	}

	@Column(name = "MONEDA_DESEMBOLSO", nullable = false, length = 3)
	public String getMonedaDesembolso() {
		return this.monedaDesembolso;
	}

	public void setMonedaDesembolso(String monedaDesembolso) {
		this.monedaDesembolso = monedaDesembolso;
	}

	@Column(name = "DESEMBOLSOS_MES_MONEDA", nullable = false, precision = 15, scale = 3)
	public BigDecimal getDesembolsosMesMoneda() {
		return this.desembolsosMesMoneda;
	}

	public void setDesembolsosMesMoneda(BigDecimal desembolsosMesMoneda) {
		this.desembolsosMesMoneda = desembolsosMesMoneda;
	}

	@Column(name = "TC_MON_USD", nullable = false, precision = 27, scale = 20)
	public BigDecimal getTcMonUsd() {
		return this.tcMonUsd;
	}

	public void setTcMonUsd(BigDecimal tcMonUsd) {
		this.tcMonUsd = tcMonUsd;
	}

	@Column(name = "DESEMBOLSOS_MES_USD", nullable = false, precision = 15, scale = 3)
	public BigDecimal getDesembolsosMesUsd() {
		return this.desembolsosMesUsd;
	}

	public void setDesembolsosMesUsd(BigDecimal desembolsosMesUsd) {
		this.desembolsosMesUsd = desembolsosMesUsd;
	}

	@Column(name = "TC_USD_GTQ", nullable = false, precision = 27, scale = 20)
	public BigDecimal getTcUsdGtq() {
		return this.tcUsdGtq;
	}

	public void setTcUsdGtq(BigDecimal tcUsdGtq) {
		this.tcUsdGtq = tcUsdGtq;
	}

	@Column(name = "DESEMBOLSOS_MES_GTQ", nullable = false, precision = 15, scale = 3)
	public BigDecimal getDesembolsosMesGtq() {
		return this.desembolsosMesGtq;
	}

	public void setDesembolsosMesGtq(BigDecimal desembolsosMesGtq) {
		this.desembolsosMesGtq = desembolsosMesGtq;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof DtmAvanceFisfinanDetDtiId))
			return false;
		DtmAvanceFisfinanDetDtiId castOther = (DtmAvanceFisfinanDetDtiId) other;

		return ((this.getEjercicioFiscal() == castOther.getEjercicioFiscal())
				|| (this.getEjercicioFiscal() != null && castOther.getEjercicioFiscal() != null
						&& this.getEjercicioFiscal().equals(castOther.getEjercicioFiscal())))
				&& ((this.getMesDesembolso() == castOther.getMesDesembolso())
						|| (this.getMesDesembolso() != null && castOther.getMesDesembolso() != null
								&& this.getMesDesembolso().equals(castOther.getMesDesembolso())))
				&& ((this.getCodigoPresupuestario() == castOther.getCodigoPresupuestario())
						|| (this.getCodigoPresupuestario() != null && castOther.getCodigoPresupuestario() != null
								&& this.getCodigoPresupuestario().equals(castOther.getCodigoPresupuestario())))
				&& (this.getEntidadSicoin() == castOther.getEntidadSicoin())
				&& (this.getUnidadEjecutoraSicoin() == castOther.getUnidadEjecutoraSicoin())
				&& ((this.getMonedaDesembolso() == castOther.getMonedaDesembolso())
						|| (this.getMonedaDesembolso() != null && castOther.getMonedaDesembolso() != null
								&& this.getMonedaDesembolso().equals(castOther.getMonedaDesembolso())))
				&& ((this.getDesembolsosMesMoneda() == castOther.getDesembolsosMesMoneda())
						|| (this.getDesembolsosMesMoneda() != null && castOther.getDesembolsosMesMoneda() != null
								&& this.getDesembolsosMesMoneda().equals(castOther.getDesembolsosMesMoneda())))
				&& ((this.getTcMonUsd() == castOther.getTcMonUsd()) || (this.getTcMonUsd() != null
						&& castOther.getTcMonUsd() != null && this.getTcMonUsd().equals(castOther.getTcMonUsd())))
				&& ((this.getDesembolsosMesUsd() == castOther.getDesembolsosMesUsd())
						|| (this.getDesembolsosMesUsd() != null && castOther.getDesembolsosMesUsd() != null
								&& this.getDesembolsosMesUsd().equals(castOther.getDesembolsosMesUsd())))
				&& ((this.getTcUsdGtq() == castOther.getTcUsdGtq()) || (this.getTcUsdGtq() != null
						&& castOther.getTcUsdGtq() != null && this.getTcUsdGtq().equals(castOther.getTcUsdGtq())))
				&& ((this.getDesembolsosMesGtq() == castOther.getDesembolsosMesGtq())
						|| (this.getDesembolsosMesGtq() != null && castOther.getDesembolsosMesGtq() != null
								&& this.getDesembolsosMesGtq().equals(castOther.getDesembolsosMesGtq())));
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37 * result + (getEjercicioFiscal() == null ? 0 : this.getEjercicioFiscal().hashCode());
		result = 37 * result + (getMesDesembolso() == null ? 0 : this.getMesDesembolso().hashCode());
		result = 37 * result + (getCodigoPresupuestario() == null ? 0 : this.getCodigoPresupuestario().hashCode());
		result = 37 * result + this.getEntidadSicoin();
		result = 37 * result + this.getUnidadEjecutoraSicoin();
		result = 37 * result + (getMonedaDesembolso() == null ? 0 : this.getMonedaDesembolso().hashCode());
		result = 37 * result + (getDesembolsosMesMoneda() == null ? 0 : this.getDesembolsosMesMoneda().hashCode());
		result = 37 * result + (getTcMonUsd() == null ? 0 : this.getTcMonUsd().hashCode());
		result = 37 * result + (getDesembolsosMesUsd() == null ? 0 : this.getDesembolsosMesUsd().hashCode());
		result = 37 * result + (getTcUsdGtq() == null ? 0 : this.getTcUsdGtq().hashCode());
		result = 37 * result + (getDesembolsosMesGtq() == null ? 0 : this.getDesembolsosMesGtq().hashCode());
		return result;
	}

}