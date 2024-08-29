package clases;

public class Ventas {
	private int codVentas , codCliente , codProducto , cantidadUnidadesVendidas;
	private String nombreProducto , nombreCliente,fecha;
	private double precioUnitario , importeSubtotal , importeIGV , importeTotalPagar;
	
	public static final double IGV;
	
	static {
		IGV = 0.18;
	}

	public Ventas(int codVentas , int codCliente, int codProducto, String nombreProducto, String nombreCliente, String fecha,
			int cantidadUnidadesVendidas ,double precioUnitario, double importeSubtotal, double importeIGV, double importeTotalPagar) {
		this.codVentas = codVentas;
		this.codCliente = codCliente;
		this.codProducto = codProducto;
		this.nombreProducto = nombreProducto;
		this.nombreCliente = nombreCliente;
		this.fecha = fecha;
		this.cantidadUnidadesVendidas = cantidadUnidadesVendidas;
		this.precioUnitario = precioUnitario;
		this.importeSubtotal = importeSubtotal;
		this.importeIGV = importeIGV;
		this.importeTotalPagar = importeTotalPagar;
	}

	public int getCodVentas() {
		return codVentas;
	}

	public void setCodVentas(int codVenta) {
		this.codVentas = codVenta;
	}

	public int getCodCliente() {
		return codCliente;
	}

	public void setCodCliente(int codCliente) {
		this.codCliente = codCliente;
	}

	public int getCodProducto() {
		return codProducto;
	}

	public void setCodProducto(int codProducto) {
		this.codProducto = codProducto;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getCantidadUnidadesVendidas() {
		return cantidadUnidadesVendidas;
	}

	public void setCantidadUnidadesVendidas(int cantidadUnidadesVendidas) {
		this.cantidadUnidadesVendidas = cantidadUnidadesVendidas;
	}

	public double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public double getImporteSubtotal() {
		return importeSubtotal;
	}

	public void setImporteSubtotal(double importeSubtotal) {
		this.importeSubtotal = importeSubtotal;
	}

	public double getImporteIGV() {
		return importeIGV;
	}

	public void setImporteIGV(double importeIGV) {
		this.importeIGV = importeIGV;
	}

	public double getImporteTotalPagar() {
		return importeTotalPagar;
	}

	public void setImporteTotalPagar(double importeTotalPagar) {
		this.importeTotalPagar = importeTotalPagar;
	}
	
	public static double calcularImporteSubTotal(double precioUnitario , double cantidadUnidadesVendidas) {
		return precioUnitario * cantidadUnidadesVendidas;
	}
	public static double calcularImporteIGV(double importeSubTotal) {
		return importeSubTotal * IGV;
	}
	public static double calcularImportePagar(double importeSubTotal , double importeIGV) {
		return importeSubTotal + importeIGV;
	}
	
}
