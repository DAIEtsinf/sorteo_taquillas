/**
 * Clase que representa a los alumnos que participan en el sorteo
 * @author Oscar
 */
public class Participante {
        //Nombre del participante
	private String nombre;
        //DNI o identificador del participante
	private String DNI;
	

        /**
         * Constructor de la clase participante.
         * @param txt debe de tener el formato "nombre, DNI"
         * @throws Exception 
         */
	public Participante (String txt) throws Exception{
            if(!txt.contains(","))throw new Exception ("El texto para crear un participante debe de contener una coma");
		setNombre(txt);
		setDNI(txt);

	}
        
        /**
         * Método para guardar el nombre del Participante.
         * @param txt 
         */
        private void setNombre(String txt){
            //Obtiene el texto hasta la coma
            this.nombre = txt.substring(0, txt.indexOf(","));
            while(this.nombre.charAt(0)==' '||this.nombre.charAt(this.nombre.length())==' ' )
                this.nombre = this.nombre.trim();
        }
        
        /**
         * Método para guardar el DNI o el identificador del participante. No se
         * pueden añadir restricciones, ya que algunos estudiantes de intercambio
         * no tienen DNI y suelen utilizar pasaporte u otros identificadores.
         * @param txt
         * @throws Exception 
         */
        private void setDNI(String txt)throws Exception{
            //Obtiene todo el texto a partir de la coma
            this.DNI = txt.substring(txt.indexOf(",") + 1);
            while(this.DNI.charAt(0)==' '||this.DNI.charAt(this.DNI.length())==' ' )
                this.DNI = this.DNI.trim();
	}

        /**
         * Método para obtener el nombre del participante.
         * @return String que representa el nombre del participante.
         */
	public String getNombre() {return nombre;}
        /**
         * Método para obtener el DNI del participante.
         * @return String que representa el DNI del participante.
         */
	public String getDNI() {return DNI;}
	
        /**
         * Método que permite imprimir por pantalla la clase Participante junto
         * con sus atributos.
         * @return String con el formato "Nombre: "+nombre+", DNI: "+dni
         */
	public String toString (){
		return "Nombre: " + getNombre() + ", DNI: " + getDNI();	
	}
<<<<<<< HEAD
	//p.equals(p1)
	public boolean equals (Participante p1){
		boolean res = false;
		
		System.out.println("ESTOS SON LOS NOMBRES QUE TIENE EQUALS");
		System.out.print(this.getNombre() + this.getDNI() + "\t");
		System.out.println(p1.getNombre() + p1.getDNI());
		
		if (this.getNombre().equals(p1.getNombre()) || this.getDNI().equals(p1.getDNI())){
			res = true;
			System.out.println("SON: " + res);
		}

		return res;
=======
	
        /**
         * Método que permite comprar los participantes. Compara los DNI, 
         * también tiene en cuenta el caso en que haya un DNI con letra y un DNI
         * sin letra. No se comparar los nombres puesto que puede haber dos
         * personas con el mismo nombre.
         * @param p participante con el que comparamos
         * @return boleean que representa si dos participantes son iguales.
         */
	public boolean equals (Participante p){	
		//if(this.getNombre().equals(p.getNombre())) return true;
                if(this.getDNI().equals(p.getDNI())) return true;
                
                //Caso en que un DNI contiene letra y el otro no
                
		return false;
>>>>>>> cc6fdf91e100b6d65846e704635c2cd234ce4e6c
	}
}

