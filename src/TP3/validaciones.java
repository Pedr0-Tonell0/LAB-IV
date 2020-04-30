package TP3;

public class validaciones {

	public static boolean verificarCampos(String nombre, String apellido, String telefono, String fechaNacimiento) {
		if(nombre == null || nombre.trim().isEmpty()) {
			return true;
		}
		if(apellido == null || apellido.trim().isEmpty()) {
			return true;
		}
		if(telefono == null || telefono.trim().isEmpty()) {
			return true;
		}
		if(fechaNacimiento == null || fechaNacimiento.trim().isEmpty()) {
			return true;
		}
		return false;
	}

	public static boolean validarCampoVacio(String dato) {
		if(dato == null || dato.trim().isEmpty()) {
			return true;
		}
		return false;
	}

	public static boolean validarCamposEjercicio2(String nota1, String nota2, String nota3) {
		if(nota1 == null || nota1.trim().isEmpty()) {
			return true;
		}
		if(nota2 == null || nota2.trim().isEmpty()) {
			return true;
		}
		if(nota3 == null || nota3.trim().isEmpty()) {
			return true;
		}
		return false;
		
	}

	public static boolean validarCamposNumericos(String nota1, String nota2, String nota3) {
		try {
			Double.parseDouble(nota1);
			Double.parseDouble(nota2);
			Double.parseDouble(nota3);
			return false;
		} catch (NumberFormatException e) {
			return true;
		}
	}

	public static double promedioDeNotas(String nota1, String nota2, String nota3) {
		return (Double.parseDouble(nota1)+Double.parseDouble(nota2)+Double.parseDouble(nota3))/3;
	}

	public static boolean notasMenorASeis(String nota1, String nota2, String nota3) {
		String nota = "6";
		if(Double.parseDouble(nota1) < Double.parseDouble(nota)) {
			return true;
		}
		if(Double.parseDouble(nota2) < Double.parseDouble(nota)) {
			return true;
		}
		if(Double.parseDouble(nota3) < Double.parseDouble(nota)) {
			return true;
		}
		return false;
	}

	public static boolean validarPromocion(String nota1, String nota2, String nota3) {
		if (Double.parseDouble(nota1) >= 8 && Double.parseDouble(nota2) >= 8 && Double.parseDouble(nota3) >= 8) {
			return true;
		}return false;
	}

	public static boolean validarAprobado(String nota1, String nota2, String nota3) {
		if (Double.parseDouble(nota1) <= 8 && Double.parseDouble(nota2) <= 8 && Double.parseDouble(nota3) <= 8
				&& Double.parseDouble(nota1) >= 6 && Double.parseDouble(nota2) >= 6 && Double.parseDouble(nota3) >= 6) {
			return true;
		}
		return false;
	}

	public static boolean verificarSistOperativo(boolean valor1, boolean valor2, boolean valor3) {
		if(valor1 || valor2 || valor3) {
			return true;
		}
		return false;
	}

	public static boolean validarCampoUnico(String horas) {
		try {
			Double.parseDouble(horas);
			return false;
		} catch (NumberFormatException e) {
			return true;
		}
	}
}
