import java.time.LocalDate;

public class Fecha {
    private int anio;
    private int mes;
    private int dia;
    private String nombreMes;


    public Fecha() {
        dia = LocalDate.now().getDayOfMonth();
        mes = LocalDate.now().getMonthValue();
        anio = LocalDate.now().getYear();
        nombreMes=getNombreMes(mes);
    }

    public Fecha(int year, String nombreMes, int day) {
        anio = year;
        mes = getNumMes(nombreMes);
        dia = day;

        if (mes > 12) {
            int cont = 0;
            while (mes > 12) {
                mes = mes - 12;
                cont++;
            }
            anio = anio + cont;
        }

        if (mes == 1 | mes == 3 | mes == 5 | mes == 7 | mes == 8 | mes == 10 | mes == 12) {
            int cont = 0;
            if (dia > 31) {
                while (dia > 31) {
                    dia = dia - 31;
                    cont++;
                }
                mes = mes + cont;
            }
        }

        if (mes == 4 | mes == 6 | mes == 9 | mes == 11) {
            int cont = 0;
            if (dia > 30) {
                while (dia > 30) {
                    dia = dia - 30;
                    cont++;
                }
                mes = mes + cont;
            }
        }

        if (mes == 2) {
            if (anio % 4 == 0 || anio % 400 == 0) {
                int cont = 0;
                if (dia > 29) {
                    while (dia > 29) {
                        dia = dia - 29;
                        cont++;
                    }
                    mes = mes + cont;
                }
            } else {
                int cont = 0;
                if (dia > 28) {
                    while (dia > 28) {
                        dia = dia - 28;
                        cont++;
                    }
                    mes = mes + cont;
                }
            }

        }
        nombreMes=getNombreMes(mes);
    }

    public boolean isBefore(Fecha fecha){
        boolean antes;
        if(anio< fecha.anio)
        {
            antes=true;
            return antes;
        }
        if(anio== fecha.anio && mes< fecha.mes)
        {
            antes=true;
            return antes;
        }
        if(anio== fecha.anio&&mes== fecha.mes&&dia< fecha.dia)
        {
            antes=true;
            return antes;
        }
        antes=false;
        return antes;
    }

    public boolean isAfter(Fecha fecha){
        boolean despues;
        if(anio> fecha.anio)
        {
            despues=true;
            return despues;
        }
        if(anio== fecha.anio && mes> fecha.mes)
        {
            despues=true;
            return despues;
        }
        if(anio== fecha.anio&&mes== fecha.mes&&dia> fecha.dia)
        {
            despues=true;
            return despues;
        }
        despues=false;
        return despues;
    }

    public boolean esMismoDia(Fecha fecha){
        boolean igual=false;
        if(dia== fecha.dia && mes==fecha.mes && anio== fecha.anio)
        {
            igual=true;
            return igual;
        }
        return igual;
    }

    public void avanzaDias(int dias) {
        dia = dia + dias;

        if (mes == 1 | mes == 3 | mes == 5 | mes == 7 | mes == 8 | mes == 10 | mes == 12) {
            int cont = 0;
            if (dia > 31) {
                while (dia > 31) {
                    dia = dia - 31;
                    cont++;
                }
                mes = mes + cont;
            }
        }

        if (mes == 4 | mes == 6 | mes == 9 | mes == 11) {
            int cont = 0;
            if (dia > 30) {
                while (dia > 30) {
                    dia = dia - 30;
                    cont++;
                }
                mes = mes + cont;
            }
        }

        if (anio % 4 == 0 || anio % 400 == 0) {
            if (mes == 2) {
                int cont = 0;
                if (dia > 29) {
                    while (dia > 29) {
                        dia = dia - 29;
                        cont++;
                    }
                    mes = mes + cont;
                }
            }
        } else {
            if (mes == 2) {
                int cont = 0;
                if (dia > 28) {
                    while (dia > 28) {
                        dia = dia - 28;
                        cont++;
                    }
                    mes = mes + cont;
                }
            }
        }
        if (mes > 12) {
            int cont = 0;
            while (mes > 12) {
                mes = mes - 12;
                cont++;
            }
            anio = anio + cont;
        }
    }

    public void retrocedeDias(int dias) {
        dia = dia - dias;
        if (dia < 1) {
            mes=mes-1;
            if (mes == 1 | mes == 3 | mes == 5 | mes == 7 | mes == 8 | mes == 10 | mes == 12) {
                int cont = -1;
                while (dia < 1) {
                    dia = dia + 31;
                    cont++;
                }
                mes = mes - cont;
                while (mes < 1) {
                    mes = mes + 12;
                }

            }
            if (mes == 4 | mes == 6 | mes == 9 | mes == 11) {
                int cont = 0;
                while (dia < 1) {
                    dia = dia + 31;
                    cont++;
                }
                mes = mes - cont;
                while (mes < 1) {
                    mes = mes + 12;
                }
            }

            if (mes == 4 | mes == 6 | mes == 9 | mes == 11) {
                int cont = 0;
                while (dia < 1) {
                    dia = dia + 31;
                    cont++;
                }
                mes = mes - cont;
                while (mes < 1) {
                    mes = mes + 12;
                }
            }

            if (mes == 2) {
                if (anio % 4 == 0 || anio % 400 == 0) {
                    int cont = 0;
                    while (dia < 1) {
                        dia = dia + 29;
                        cont++;
                    }
                    mes = mes - cont;
                    while (mes < 1) {
                        mes = mes + 12;
                    }
                } else {
                    int cont = 0;
                    while (dia < 1) {
                        dia = dia + 28;
                        cont++;
                    }
                    mes = mes - cont;
                    while (mes < 1) {
                        mes = mes + 12;
                    }
                }
            }
        }
    }

    public int diferenciaEnDias(Fecha fecha2){
        int difEnAnios, difEnMeses, difEnDias;
        int dias=0;
        difEnAnios=anio-fecha2.anio;
        difEnMeses=mes-fecha2.mes;
        difEnDias=dia- fecha2.dia;
        dias=(Math.abs(difEnAnios)*365)+(Math.abs(difEnMeses)*30)+(Math.abs(difEnDias));

        return dias;
    }

    public int diferenciaEnAnios(Fecha fecha2){
        int difEnAnios=0;
        difEnAnios=Math.abs(anio-fecha2.anio);
        return difEnAnios;
    }

    public String format(String formato)
    {
        String salidaFecha="";
        String f1="yyyy/mm/dd";
        String f2="dd/mm/yyyy";
        String f3="yyyy/dd/mm";
        String f4="yyyy-mm-dd";
        String f5="dd-mm-yyyy";
        String f6="yyyy-dd-mm";

        if(formato==f1){
            salidaFecha=anio+"/"+mes+"/"+dia;
        }
        if(formato==f2){
            salidaFecha=dia+"/"+mes+"/"+anio;
        }
        if(formato==f3){
            salidaFecha=anio+"/"+dia+"/"+mes;
        }
        if(formato==f4){
            salidaFecha=anio+"-"+mes+"-"+dia;
        }
        if(formato==f5){
            salidaFecha=dia+"-"+mes+"-"+anio;
        }
        if(formato==f6){
            salidaFecha=anio+"-"+dia+"-"+mes;
        }
        return salidaFecha;
    }

    public String getNombreMes(int mes){
        String nombre="";
        if(mes==1){
            nombre="ENERO";
        }if(mes==2){
            nombre="FEBRERO";
        }if(mes==3) {
            nombre = "MARZO";
        }if(mes==4) {
            nombre = "ABRIL";
        }if(mes==5) {
            nombre = "MAYO";
        }if(mes==6) {
            nombre = "JUNIO";
        }if(mes==7) {
            nombre = "JULIO";
        }if(mes==8) {
            nombre = "AGOSTO";
        }if(mes==9) {
            nombre = "SEPTIEMBRE";
        }if(mes==10) {
            nombre = "OCTUBRE";
        }if(mes==11) {
            nombre = "NOVIEMBRE";
        }if(mes==12) {
            nombre = "DICIEMBRE";
        }
        return nombre;
    }

    public int getNumMes(String nombreMes){
        int num=0;
        if(nombreMes=="ENERO"){
            num = 01;
        }else if(nombreMes=="FEBRERO"){
            num = 02;
        }else if(nombreMes=="MARZO") {
            num = 03;
        }else if(nombreMes=="ABRIL") {
            num = 04;
        }else if(nombreMes=="MAYO") {
            num = 05;
        }else if(nombreMes=="JUNIO") {
            num = 06;
        }else if(nombreMes=="JULIO") {
            num = 07;
        }else if(nombreMes=="AGOSTO") {
            num = 8;
        }else if(nombreMes=="SEPTIEMBRE") {
            num = 9;
        }else if(nombreMes=="OCTUBRE") {
            num = 10;
        }else if(nombreMes=="NOVIEMBRE") {
            num = 11;
        }else if(nombreMes=="DICIEMBRE") {
            num = 12;
        }
        return num;
    }
}
