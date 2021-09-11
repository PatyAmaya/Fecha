import java.time.LocalDate;

public class Fecha {
    private int anio;
    private int mes;
    private int dia;


    public Fecha() {
        dia = LocalDate.now().getDayOfMonth();
        mes = LocalDate.now().getMonthValue();
        anio = LocalDate.now().getYear();
    }

    public Fecha(int year, int month, int day) {
        anio = year;
        mes = month;
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
        int difEnAnios;
        difEnAnios=Math.abs(anio-fecha2.anio);
        return difEnAnios;
    }

 /*   public void format(String formato)
    {
        String f1="yyyy/mm/dd";
        String f2="dd/mm/yyyy";
        String f3="yyyy/dd/mm";
        String f4="yyyy-mm-dd";
        String f5="dd-mm-yyyy";
        String f6="yyyy-dd-mm";

        if(formato.compareTo(f1)){

        }
    }*/
}
