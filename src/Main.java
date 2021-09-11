import java.time.*;

public class TestFecha
{
    public static void main(String []args){
        Fecha fechaNacimientoJuan = new Fecha(2011, JULIO, 10);
        Fecha fechaIngresoJuan = new Fecha(2018, AGOSTO, 25);

        Fecha fechaNacimientoMaria = new Fecha(2012, ENERO, 10);
        Fecha fechaIngresoMaria = new Fecha(2017, NOVIEMBRE, 15);

        Fecha fechaActual = new Fecha();

        System.out.println("Hoy es: " + fechaActual.format("dd/mm/yyyy"));

        System.out.println("Juan nació el: " + fechaNacimientoJuan.format("dd/mm/yyyy") + ", hace " + fechaNacimientoJuan.diferenciaEnAnios(fechaActual) + " años");

        System.out.println("Maria nació el: " + fechaNacimientoMaria.format("dd/mm/yyyy") + ", hace " + fechaNacimientoMaria.diferenciaEnAnios(fechaActual) + " años");

        if(fechaNacimientoJuan.isAfter(fechaNacimientoMaria)){
            System.out.println("Juan nació " + fechaNacimientoJuan.diferenciaEnDias(fechaNacimientoMaria) +  " dias después de Maria");
        } else {
            System.out.println("Juan nació " + fechaNacimientoJuan.diferenciaEnDias(fechaNacimientoMaria) +  " dias antes de Maria");
        }

        if(fechaIngresoMaria.isBefore(fechaIngresoJuan)){
            System.out.println("Maria ingresó " + fechaNacimientoJuan.diferenciaEnDias(fechaNacimientoMaria) +  " días antes que Juan");
        } else {
            System.out.println("Maria ingresó " + fechaNacimientoJuan.diferenciaEnDias(fechaNacimientoMaria) +  " días después que Juan");
        }

        System.out.println("Desde que ingresó Juan en " + fechaIngresoJuan.format("yyyy-mm-dd") + " han pasado " + fechaActual.diferenciaEnAnios(fechaIngresoJuan) + " años");
        System.out.println("Desde que ingresó Maria en " + fechaIngresoJuan.format("yyyy-mm-dd") + " han pasado " + fechaActual.diferenciaEnAnios(fechaNacimientoMaria) + " años");

    }
}


/*public class Main {

    public static void main(String[] args) {
        int diferenciaEnDias = 0, diferenciaEnAnios = 0;
        boolean antes, despues, igual;
        //Fecha fecha=new Fecha();

        Fecha fecha1 = new Fecha(2001, 12, 14);

        Fecha fecha2 = new Fecha(2001, 12, 11);

        //fecha2.avanzaDias(45);
        //fecha.retrocedeDias(35);

        diferenciaEnDias = fecha1.tiempoTranscurridoEnDias(fecha2);
        System.out.println("Dias: " + diferenciaEnDias);

        diferenciaEnAnios = fecha1.tiempoTranscurridoEnAnios(fecha2);
        System.out.println("Anios: " + diferenciaEnAnios);

        antes = fecha2.esAntes(fecha1);
        if (antes == true) {
            System.out.println("Sí es antes");
        } else {
            System.out.println("No es antes");
        }

        despues = fecha2.esDespues(fecha1);
        if (despues == true) {
            System.out.println("Sí es despues");
        } else {
            System.out.println("No es despues");
        }

        igual = fecha1.esMismoDia(fecha2);
        if (igual == true) {
            System.out.println("Es el mismo dia");
        } else {
            System.out.println("No es el mismo dia");
        }
    }
}*/


