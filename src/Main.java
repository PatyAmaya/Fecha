import java.time.*;

public class Main
{
    public static void main(String []args){
        Fecha fechaNacimientoJuan = new Fecha(2011, "JULIO", 10);
        Fecha fechaIngresoJuan = new Fecha(2018, "AGOSTO", 25);

        Fecha fechaNacimientoMaria = new Fecha(2012, "ENERO", 10);
        Fecha fechaIngresoMaria = new Fecha(2017, "NOVIEMBRE", 15);

        Fecha fechaActual = new Fecha();

        System.out.println("Hoy es: "+ fechaActual.format("dd/mm/yyyy"));

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
        System.out.println("Desde que ingresó Maria en " + fechaIngresoJuan.format("yyyy-mm-dd") + " han pasado " + fechaActual.diferenciaEnAnios(fechaIngresoMaria) + " años");

    }
}



