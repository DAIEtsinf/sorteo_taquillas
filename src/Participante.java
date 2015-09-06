package SorteoDeTaquillas;

public class Participante {
	
	private String nombre;
	private String DNI;
	
	public Participante (String linea) throws Exception{
	
		this.nombre = linea.substring(0, linea.indexOf(","));
		this.DNI = setDNI(linea.substring(linea.indexOf(",") + 1));
	}

	public String setDNI(String dni)throws Exception{
	
		if(dni.length()<=0) throw new Exception ("El dni no puede ser  nulo");
		return dni;
	}
	
	//Métodos para obtener el nombre y el DNI de susodichos
	public String getNombre() {return nombre;}
	public String getDNI() {return DNI;}
	
	//Nos falta el método toString y nos falta el método equals.
	public String toString (){
		String res = "";
		res += "Nombre: " + getNombre() + ", DNI: " + getDNI();
		return res;	
	}
	//p.equals(p1)
	public boolean equals (Participante p1){
		boolean res = false;
		
		System.out.println("ESTOS SON LOS NOMBRES QUE TIENE EQUALS");
		System.out.print(this.getNombre() + this.getDNI() + "\t");
		System.out.println(p1.getNombre() + p1.getDNI());
		
		if (this.getNombre() == p1.getNombre() && this.getDNI() == p1.getDNI())
			res = true;
		System.out.println("Son iguales" + res);
		return res;
	}
}

