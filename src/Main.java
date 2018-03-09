import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        int opcion;
        boolean salir=false;
        int opcionPrincipal;
        ArrayList<Long> time = new ArrayList<>();
        ArrayList<Palabra> paqViajes = new ArrayList<>();
        ArrayList<Palabra> palabrasErroneas = new ArrayList<>();
        ArrayList<PhrasalVerbs> phrasalVerbs = new ArrayList<>();
        ArrayList<String> diccionarioIngles = new ArrayList<>();
        ArrayList<String> diccionarioEspannol = new ArrayList<>();
        ArrayList<String> linea = new ArrayList<>();
        ArrayList<String> phrasal = new ArrayList<>();

        cargarArchivoPalabras(linea);
        cargarArchivoPhrasal(phrasal);
        cargarArchivoEstadisticas(time);
        cargarDiccionarios(diccionarioIngles, diccionarioEspannol);

        System.out.println("Todo correcto");

        rellenarObjetoPalabra(linea, paqViajes);
        rellenarObjetoPhasal(phrasal, phrasalVerbs);

        mostrarMenuPrincipal();
        opcionPrincipal = sn.nextInt();
        while (!salir) {
            switch (opcionPrincipal) {
                case 1:
                    mostrarMenuEstudiar();
                    opcion = sn.nextInt();
                    switch (opcion){
                        case 1:
                            do {
                                mostrarMenuPalabras();
                                opcion = sn.nextInt();
                                switch (opcion) {
                                    case 1:
                                        nuevaPalabra(paqViajes, diccionarioIngles, diccionarioEspannol);
                                        break;
                                    case 2:
                                        estudiar(paqViajes, palabrasErroneas, time);
                                        break;
                                    case 3:
                                        traductor(paqViajes);
                                        break;
                                    case 4:
                                        editarPalabra(paqViajes, diccionarioIngles, diccionarioEspannol);
                                        break;
                                    case 5:
                                        eliminarPalabra(paqViajes);
                                        break;
                                    case 6:
                                        eliminarTodas(paqViajes);
                                        break;
                                    case 7:
                                        mostrarTodas(paqViajes);
                                        break;
                                    case 8:
                                        System.out.println("Has elegido salir");
                                        salir = true;
                                        break;
                                    default:
                                        System.out.println("No has elegido una opcion válida");
                                        break;
                                }
                            } while (opcion != 8);
                            rellenarPalabras(paqViajes);
                            break;
                        case 2:
                            do {
                                mostrarMenuPhrasalVerbs();
                                opcion = sn.nextInt();
                                switch (opcion){
                                    case 1:
                                        nuevoPhrasalVerb(phrasalVerbs);
                                        break;
                                    case 2:
                                        estudiar(phrasalVerbs, time);
                                        break;
                                    case 3:
                                        traductorPhrasal(phrasalVerbs);
                                        break;
                                    case 4:
                                        editarPhrasal(phrasalVerbs);
                                        break;
                                    case 5:
                                        eliminarPhrasal(phrasalVerbs);
                                        break;
                                    case 6:
                                        mostrarTodos(phrasalVerbs);
                                        break;
                                    case 7:
                                        eliminarTodos(phrasalVerbs);
                                        break;
                                    case 8:
                                        System.out.println("Has elegido salir");
                                        break;
                                        default:
                                            System.out.println("No has elegido una opción válida");
                                            break;
                                }

                            }while (opcion!= 8);
                            break;
                        case 3:
                            System.out.println("Has elegido salir");
                            salir = true;
                            break;
                            default:
                                System.out.println("No has elegido una opcion válida");
                                break;
                    }
                    break;
                case 2:
                    do {
                        mostrarMenuEstadisticas();
                        opcion = sn.nextInt();
                        switch (opcion){
                            case 1:
                                nEstudio(time);
                                break;
                            case 2:
                                tiempoEstudio(time);
                                break;
                            case 3:
                                System.out.println("Has elegido salir");
                                salir = true;
                                break;
                                default:
                                    System.out.println("No has elegido una opcion válida");
                                    break;
                        }
                    }while (opcion!=5);
                    break;
                case 3:
                    do {
                        mostrarMenuSeguridad();
                        opcion = sn.nextInt();
                        switch (opcion) {
                            case 1:
                                copiaDeSeguridad();
                                break;
                            case 2:
                                restaurarCopiaSeguridad();
                                break;
                            case 3:
                                System.out.println("Has elegido salir");
                                salir = true;
                                break;
                            default:
                                System.out.println("No has elegido una opcion válida");
                                break;
                        }
                    } while (opcion != 3);
                    rellenarPalabras(paqViajes);
                    break;
                case 4:
                    System.out.println("Has elegido salir");
                    salir = true;
                    break;
                default:
                    break;
            }
        }
    }
    /////////////////////*******************************MENUS***********************************//////////////////////
    private static void mostrarMenuPrincipal(){
        System.out.println("1. Estudiar");
        System.out.println("2. Estadisticas");
        System.out.println("3. Copia de seguridad y recuperacion");
        System.out.println("4. Salir");
    }
    private static void mostrarMenuEstudiar(){
        System.out.println("1. Estudiar vocabulario");
        System.out.println("2. Estudiar phrasal verbs");
        System.out.println("3. Salir");
    }
    private static void mostrarMenuPalabras(){
        System.out.println("1. Introducir palabra");
        System.out.println("2. Estudiar");
        System.out.println("3. Buscar traduccion de una palabra");
        System.out.println("4. Editar una palabra");
        System.out.println("5. Eliminar palabra del paquete");
        System.out.println("6. Eliminar todas las palabras");
        System.out.println("7. Mostrar todas las palabras del paquete");
        System.out.println("8. Salir");
    }
    private static void mostrarMenuPhrasalVerbs(){
        System.out.println("1. Introducir nuevo Phrasal Verb");
        System.out.println("2. Estudiar");
        System.out.println("3. Buscar traduccion de un Phrasal Verb");
        System.out.println("4. Editar un Phrasal Verb");
        System.out.println("5. Eliminar Phrasal Verb del paquete");
        System.out.println("6. Eliminar todos los Phrasal Verbs");
        System.out.println("7. Mostrar todos los Phrasal Verbs del paquete");
        System.out.println("8. Salir");
    }
    private static void mostrarMenuSeguridad(){
        System.out.println("1. Crear copia de seguridad");
        System.out.println("2. Restaurar copia de seguridad");
        System.out.println("3. Salir");
    }
    private static void mostrarMenuEstadisticas(){
        System.out.println("1. Numero de veces estudiado");
        System.out.println("2. Tiempo estudiado");
        System.out.println("3. Salir");
    }
    ////////////////////***********************************************************************//////////////////////

    ////////////////////******************************PALABRAS*********************************//////////////////////
    private static void nuevaPalabra(ArrayList<Palabra> paqViajes, ArrayList<String> diccionarioIngles, ArrayList<String> diccionarioEspannol){
        Scanner sc = new Scanner(System.in);
        Palabra palabra = new Palabra();
        String ing;
        boolean check = true;
        boolean checkIng = false;
        boolean palabraEspecial = false;
        System.out.println("Palabra nueva: ");
        System.out.print("Español --> ");
        ing = sc.nextLine().toLowerCase();
        if (ing.endsWith("*")){
            palabraEspecial = true;
            ing = ing.substring(0,ing.length()-1);
            checkIng = true;
        }
        if (!palabraEspecial) {
            for (String palabra1 : diccionarioEspannol) {
                if (palabra1.equalsIgnoreCase(ing)) {
                    palabra.setEsp(ing);
                    checkIng = true;
                }
            }
        }
        palabraEspecial = false;
        if (checkIng) {
            for (Palabra palabra1 : paqViajes) {
                if (palabra1.getEsp().equalsIgnoreCase(ing)) {
                    check = false;
                    break;
                }
            }
            if (check) {
                palabra.setEsp(ing);
                checkIng = false;
                System.out.print("Ingles --> ");
                ing = sc.nextLine().toLowerCase();
                if (ing.endsWith("*")){
                    palabraEspecial = true;
                    ing = ing.substring(0,ing.length()-1);
                    checkIng = true;
                }
                if (!palabraEspecial) {
                    for (String palabra1 : diccionarioIngles) {
                        if (palabra1.equalsIgnoreCase(ing)) {
                            checkIng = true;
                        }
                    }
                }
                if (checkIng) {
                    palabra.setIng(ing);
                    paqViajes.add(palabra);
                    rellenarPalabras(paqViajes);
                } else {
                    System.out.println("No existe esa palabra en ingles");
                }
            } else {
                System.out.println("Esa palabra ya está introducida");
            }
        }else{
            System.out.println("No existe esa palabra en español");
        }

    }
    private static void estudiar(ArrayList<Palabra> paqViajes, ArrayList<Palabra> palabrasErroneas, ArrayList<Long> time){
        ArrayList<Palabra> estudiarPalabras = new ArrayList<>(paqViajes);
        Scanner sc = new Scanner(System.in);
        String ing;
        int aciertos = 0;
        int fallos = 0;
        boolean checkError = false;
        long starTime;
        long endTime;
        int random;
        starTime = System.currentTimeMillis();
        do {
            random = (int) (Math.random() * estudiarPalabras.size()) + 1;
            while (random==estudiarPalabras.size()) {
                random = (int) (Math.random() * estudiarPalabras.size()) + 1;
                if (random == 1 && estudiarPalabras.size() == 1){
                    random=0;
                    break;
                }
            }
                System.out.print(estudiarPalabras.get(random).getEsp() + "--> ");
                ing = sc.nextLine().toLowerCase();

                if (ing.equalsIgnoreCase("salir")) {
                    break;
                } else if (ing.equalsIgnoreCase(estudiarPalabras.get(random).getIng())) {
                    aciertos++;
                    estudiarPalabras.remove(estudiarPalabras.get(random));
                } else {
                    Palabra palabraErronea = new Palabra();
                    System.out.println("Incorrecto, otra vez será");
                    if (palabrasErroneas.size() == 0) {
                        palabraErronea.setEsp(estudiarPalabras.get(random).getEsp());
                        palabraErronea.setIng(estudiarPalabras.get(random).getIng());
                        palabrasErroneas.add(palabraErronea);
                    } else {
                        for (Palabra palabra : palabrasErroneas) {
                            if (palabra.getEsp().equalsIgnoreCase(estudiarPalabras.get(random).getEsp())) {
                                checkError = true;
                            }
                        }
                        if (!checkError) {
                            palabraErronea.setEsp(estudiarPalabras.get(random).getEsp());
                            palabraErronea.setIng(estudiarPalabras.get(random).getIng());
                            palabrasErroneas.add(palabraErronea);
                        }
                    }
                    fallos++;
                    checkError = false;
                }
                if (estudiarPalabras.size() == 0){
                    ing = "salir";
                }
        }while (!ing.equalsIgnoreCase("salir"));
        estudiarPalabras.clear();
        endTime = System.currentTimeMillis();
        System.out.println("Número de palabras correctas --> "+aciertos);
        System.out.println("Número de palabras fallidas --> "+fallos);
        System.out.println("Has estudiado "+((endTime-starTime)/1000)+" segundos.");
        time.add((endTime-starTime)/1000);
        rellenarEstadisticas(time);
        if (palabrasErroneas.size() == 0) {
            System.out.println();
            System.out.println("****************************************************");
            System.out.println("Enhorabuena, has acertado todas! Sigue así!");
            System.out.println("****************************************************");
            System.out.println();
        }else{
            System.out.println("¿Desea ver sus fallos?");
            ing = sc.nextLine();
            ing = ing.toLowerCase();
            if (ing.equalsIgnoreCase("si")) {
                for (Palabra palabra : palabrasErroneas) {
                    System.out.println(palabra.getEsp() + " | " + palabra.getIng());
                }
            } else {
                System.out.println("Hasta luego!");
            }
        }
    }
    private static void traductor(ArrayList<Palabra> paqViajes){
        Scanner sc = new Scanner(System.in);
        String line;
        System.out.print("Palabra--> ");
        line = sc.nextLine();
        for (Palabra palabra : paqViajes) {
            if (palabra.getEsp().equalsIgnoreCase(line)){
                System.out.println("Traduccion --> "+palabra.getIng());
            }else if (palabra.getIng().equalsIgnoreCase(line)){
                System.out.println("Traduccion --> "+palabra.getEsp());
            }
        }
    }
    private static void editarPalabra(ArrayList<Palabra> paqViajes, ArrayList<String> diccionarioIngles, ArrayList<String> diccionarioEspannol){
        Scanner sc = new Scanner(System.in);
        String line;
        String lineaux;
        boolean check=false;
        boolean checkaux=false;
        boolean palabraEspecial=false;
        int pos = 0;
        System.out.println("¿Qué palabra desea editar?");
        line = sc.nextLine();
        for (Palabra palabra : paqViajes) {
            if (palabra.getEsp().equalsIgnoreCase(line) || palabra.getIng().equalsIgnoreCase(line)){
                checkaux = true;
            }
        }
        if (checkaux) {
            System.out.println("¿Que desea editar? 1. Español - 2. Ingles");
            lineaux = sc.nextLine();
            for (int i = 0; i < paqViajes.size(); i++) {
                if (paqViajes.get(i).getEsp().equalsIgnoreCase(line) || paqViajes.get(i).getIng().equalsIgnoreCase(line)) {
                    check = true;
                    pos = i;
                    break;
                }
            }
            if (check) {
                if (lineaux.equalsIgnoreCase("1")) {
                    System.out.print("Dime la nueva palabra en español -->");
                    line = sc.nextLine();
                    if (line.endsWith("*")){
                        palabraEspecial = true;
                        line = line.substring(0, line.length()-1);
                        check = false;
                    }
                    if (!palabraEspecial) {
                        for (String palabra : diccionarioEspannol) {
                            if (palabra.equalsIgnoreCase(line)) {
                                check = false;
                            }
                        }
                    }
                    if (!check){
                        paqViajes.get(pos).setEsp(line);
                        System.out.println("La palabra ha sido editada");
                        rellenarPalabras(paqViajes);
                    }else{
                        System.out.println("No existe esa palabra en español");
                    }

                } else if (lineaux.equalsIgnoreCase("2")) {
                    System.out.print("Dime la nueva palabra en ingles -->");
                    line = sc.nextLine();
                    if (line.endsWith("*")){
                        palabraEspecial = true;
                        line = line.substring(0, line.length()-1);
                        check = false;
                    }
                    if (!palabraEspecial) {
                        for (String palabra : diccionarioIngles) {
                            if (palabra.equalsIgnoreCase(line)) {
                                check = false;
                            }
                        }
                    }
                    if (!check){
                        paqViajes.get(pos).setIng(line);
                        System.out.println("La palabra ha sido editada");
                        rellenarPalabras(paqViajes);
                    }else{
                        System.out.println("No existe esa palabra en ingles");
                    }
                }else {
                    System.out.println("Esta palabra no existe en nuestro vocabulario");
                }
            }
        }else{
            System.out.println("La palabra no existe en nuestro vocabulario");
        }
    }
    private static void eliminarPalabra(ArrayList<Palabra> paqViajes){
        Scanner sc = new Scanner(System.in);
        String aux;
        int pos=0;
        boolean check = false;
        System.out.print("Palabra --> ");
        aux = sc.nextLine();
        for (int i = 0; i < paqViajes.size(); i++) {
            if (paqViajes.get(i).getEsp().equalsIgnoreCase(aux) || paqViajes.get(i).getIng().equalsIgnoreCase(aux)){
                check = true;
                pos = i;
                break;
            }
        }
        if (check){
            paqViajes.remove(paqViajes.get(pos));
            System.out.println("La palabra ha sido eliminada");
            rellenarPalabras(paqViajes);
        }else{
            System.out.println("La palabra no existe en nuestro vocabulario.");
        }
    }
    private static void mostrarTodas(ArrayList<Palabra> paqViajes){
        System.out.println("*****************************************************");
        for (Palabra palabra : paqViajes) {
            System.out.println(palabra.getEsp()+"|"+palabra.getIng());
        }
        System.out.println("*****************************************************");
        System.out.println();
    }
    private static void eliminarTodas(ArrayList<Palabra> paqViajes){
        Scanner sc = new Scanner(System.in);
        String resp;
        System.out.println("¿Estas seguro que desea borrar todas las palabras del paquete? No podrá volver atrás!!!!!!!!!!!!!!!");
        resp = sc.nextLine().toLowerCase();
        if (resp.equalsIgnoreCase("si")){
            System.out.println("Vamos a proceder a borrar todo el paquete. ¿Está de acuerdo?");
            resp = sc.nextLine().toLowerCase();
            if (resp.equalsIgnoreCase("si")){
                paqViajes.clear();
                System.out.println("Su paquete ha sido borrado");
            }
        }
    }
    ////////////////////***********************************************************************//////////////////////

    ////////////////////*****************************PHRASAL VERBS*****************************//////////////////////
    private static void nuevoPhrasalVerb(ArrayList<PhrasalVerbs> phrasalVerbs) {
        Scanner sc = new Scanner(System.in);
        String line;
        boolean check = false;
        PhrasalVerbs phrasalVerbs1 = new PhrasalVerbs();
        System.out.print("Ingles --> ");
        line = sc.nextLine();
        for (PhrasalVerbs phrasalverb : phrasalVerbs) {
            if (phrasalverb.getIngles().equalsIgnoreCase(line)){
                check = true;
            }
        }
        if (!check) {
            phrasalVerbs1.setIngles(line);
            System.out.print("Español --> ");
            phrasalVerbs1.setEspannol(sc.nextLine());
            System.out.print("Ejemplo de uso --> ");
            phrasalVerbs1.setUso(sc.nextLine());
            phrasalVerbs.add(phrasalVerbs1);
            rellenarPhrasal(phrasalVerbs);
        }else {
            System.out.println("El phrasal verb ya está introducido");
        }
    }
    private static void estudiar(ArrayList<PhrasalVerbs> phrasalVerbs, ArrayList<Long> time){
        ArrayList<PhrasalVerbs> estudiarPhrasal = new ArrayList<>(phrasalVerbs);
        ArrayList<PhrasalVerbs> erroresPhrasal = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String line;
        int aciertos = 0;
        int fallos = 0;
        int random;
        long starTime;
        long endTime;
        boolean check = false;
        starTime = System.currentTimeMillis();
        do {
            random = (int) (Math.random() * estudiarPhrasal.size()) + 1;
            while (random==estudiarPhrasal.size()) {
                random = (int) (Math.random() * estudiarPhrasal.size()) + 1;
                if (random == 1 && estudiarPhrasal.size() == 1){
                    random=0;
                    break;
                }
            }
            System.out.print(estudiarPhrasal.get(random).getIngles() + "--> ");
            line = sc.nextLine();
            if (line.equalsIgnoreCase("Salir")){
                break;
            }else if (estudiarPhrasal.get(random).getEspannol().equalsIgnoreCase(line)){
                aciertos++;
                estudiarPhrasal.remove(estudiarPhrasal.get(random));
            }else{
                PhrasalVerbs phrasalVerbs1 = new PhrasalVerbs();
                System.out.println("Incorrecto, otra vez será");
                if (erroresPhrasal.size() == 0) {
                    phrasalVerbs1.setEspannol(estudiarPhrasal.get(random).getEspannol());
                    phrasalVerbs1.setIngles(estudiarPhrasal.get(random).getIngles());
                    erroresPhrasal.add(phrasalVerbs1);
                } else {
                    for (PhrasalVerbs phrasalVerbs2 : erroresPhrasal) {
                        if (phrasalVerbs2.getEspannol().equalsIgnoreCase(estudiarPhrasal.get(random).getEspannol())) {
                            check = true;
                        }
                    }
                    if (!check) {
                        phrasalVerbs1.setEspannol(estudiarPhrasal.get(random).getEspannol());
                        phrasalVerbs1.setIngles(estudiarPhrasal.get(random).getIngles());
                        erroresPhrasal.add(phrasalVerbs1);
                    }
                }
                fallos++;
                check = false;
            }
            if (estudiarPhrasal.size() == 0){
                line = "salir";
            }
        }while (!line.equalsIgnoreCase("salir"));
        endTime = System.currentTimeMillis();
        System.out.println("Aciertos --> "+ aciertos);
        System.out.println("Fallos --> "+ fallos);
        System.out.println("Has estudiado "+((endTime-starTime)/1000)+" segundos.");
        time.add((endTime-starTime)/1000);
        rellenarEstadisticas(time);
        if (aciertos == 0){
            System.out.println("Enhorabuena, has acertado todo!!");
        }else{
            System.out.println("Desea ver sus fallos?");
            line = sc.nextLine().toLowerCase();
            if (line.equalsIgnoreCase("si")){
                for (PhrasalVerbs phrasalverb : erroresPhrasal) {
                    System.out.println(phrasalverb.getIngles()+" | "+phrasalverb.getEspannol());
                }
            }else{
                System.out.println("Sigue intentandolo");
            }
        }

    }
    private static void traductorPhrasal(ArrayList<PhrasalVerbs> phrasalVerbs){
        Scanner sc = new Scanner(System.in);
        String line;
        System.out.print("Phrasal Verb--> ");
        line = sc.nextLine();
        for (PhrasalVerbs phrasalVerbs1 : phrasalVerbs) {
            if (phrasalVerbs1.getEspannol().equalsIgnoreCase(line)){
                System.out.println("Traduccion --> "+phrasalVerbs1.getIngles());
                break;
            }else if (phrasalVerbs1.getIngles().equalsIgnoreCase(line)){
                System.out.println("Traduccion --> "+phrasalVerbs1.getEspannol());
                break;
            }
        }
    }
    private static void editarPhrasal(ArrayList<PhrasalVerbs> phrasalVerbs){
        Scanner sc = new Scanner(System.in);
        Scanner sn = new Scanner(System.in);
        String line;
        int opcion;
        System.out.println("Phrasal --> ");
        line = sc.nextLine().toLowerCase();
        for (PhrasalVerbs phrasal : phrasalVerbs) {
            if (phrasal.getEspannol().equalsIgnoreCase(line) || phrasal.getIngles().equalsIgnoreCase(line)){
                System.out.println("¿Cambiar ingles o español? 1. Ingles o 2. Español");
                opcion = sn.nextInt();
                if (opcion == 1){
                    System.out.print("Ingles --> ");
                    line = sc.nextLine().toLowerCase();
                    phrasal.setIngles(line);
                }else if(opcion == 2){
                    System.out.print("Español --> ");
                    line = sc.nextLine().toLowerCase();
                    phrasal.setEspannol(line);
                }
            }
        }
    }
    private static void eliminarPhrasal(ArrayList<PhrasalVerbs> phrasalVerbs){
        Scanner sc = new Scanner(System.in);
        String line;
        System.out.print("Phrasal Verb -->");
        line = sc.nextLine();
        for (PhrasalVerbs phrasalVerb : phrasalVerbs) {
            if (phrasalVerb.getIngles().equalsIgnoreCase(line) || phrasalVerb.getEspannol().equalsIgnoreCase(line)){
                phrasalVerbs.remove(phrasalVerb);
            }
        }
    }
    private static void mostrarTodos(ArrayList<PhrasalVerbs> phrasalVerbs){
        for (PhrasalVerbs phrasalverb : phrasalVerbs) {
            System.out.println(phrasalverb.getEspannol() +" | "+ phrasalverb.getIngles());
        }
    }
    private static void eliminarTodos(ArrayList<PhrasalVerbs> phrasalVerbs){
        Scanner sc = new Scanner(System.in);
        String resp;
        System.out.println("¿Estas seguro que desea borrar todos los phrasal verbs del paquete? No podrá volver atrás!!!!!!!!!!!!!!!");
        resp = sc.nextLine().toLowerCase();
        if (resp.equalsIgnoreCase("si")){
            System.out.println("Vamos a proceder a borrarlos todos. ¿Está de acuerdo?");
            resp = sc.nextLine().toLowerCase();
            if (resp.equalsIgnoreCase("si")){
                phrasalVerbs.clear();
                System.out.println("Borrado exitoso");
            }
        }
    }
    ////////////////////***********************************************************************//////////////////////

    ////////////////////******************************ESTADISTICAS*****************************//////////////////////
    private static void nEstudio(ArrayList<Long> time){
        System.out.println("Has estudiado "+time.size()+" veces.");
    }
    private static void tiempoEstudio(ArrayList<Long> time){
        long tiempo = 0;
        long minuto;
        for (long Time : time) {
            tiempo = tiempo + Time;
        }
        minuto = tiempo / 60;
        System.out.println("Has estudiado "+minuto+" minutos");
    }
    ////////////////////***********************************************************************//////////////////////

    ////////////////////******************************SEGURIDAD********************************//////////////////////
    private static void copiaDeSeguridad(){
        Scanner sn = new Scanner(System.in);
        int opcion;
        String copia = "";
        System.out.println("¿A que archivo desea hacer la copia de seguridad? 1. Palabras");
        opcion = sn.nextInt();
        if (opcion == 1){
            copia="palabras.txt";
        }
        File origen = new File("C:\\Users\\alexs\\IdeaProjects\\AprendeInglesConAlex\\"+copia+"");
        File destino = new File("C:\\aprenderingles\\"+copia+"");


        try {
            System.out.println("Haciendo copia de seguridad...");
            InputStream in = new FileInputStream(origen);
            OutputStream out = new FileOutputStream(destino);

            byte[] buf = new byte[1024];
            int len;

            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }

            in.close();
            out.close();
            System.out.println("Ok");
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
    private static void restaurarCopiaSeguridad(){
        Scanner sn = new Scanner(System.in);
        int opcion;
        String copia = "";
        System.out.println("¿A que archivo desea hacer la restauracion de seguridad? 1. Palabras");
        opcion = sn.nextInt();
        if (opcion == 1){
            copia="palabras.txt";
        }
        File origen = new File("C:\\aprenderingles\\"+copia+"");
        File destino = new File("C:\\Users\\alexs\\IdeaProjects\\AprendeInglesConAlex\\"+copia+"");

        try {
            System.out.println("Restaurando copia de seguridad...");
            InputStream in = new FileInputStream(origen);
            OutputStream out = new FileOutputStream(destino);

            byte[] buf = new byte[1024];
            int len;

            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }

            in.close();
            out.close();
            System.out.println("Ok");
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
    ////////////////////***********************************************************************//////////////////////

    ////////////////////*********************CARGAS Y RELLENOS DE ARCHIVOS*********************//////////////////////
    private static void cargarArchivoPalabras(ArrayList<String> linea){
        String ruta = "palabras.txt";
        File fichero = new File(ruta);
        String line;
        boolean check;
        if (!fichero.exists()){
            try {
                System.out.println("Creando archivo...");
                check = fichero.createNewFile();
                if (check){
                System.out.println("Ok");
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }else{
            try {
                System.out.println("Cargando paquete de vocabulario...");
                BufferedReader br = new BufferedReader(new FileReader(ruta));
                line = br.readLine();
                while (line!=null){
                    linea.add(line);
                    line = br.readLine();
                }
                br.close();
                System.out.println("Ok");
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    private static void cargarArchivoPhrasal(ArrayList<String> phrasal){
        String ruta = "phrasalVerbs.txt";
        File fichero = new File(ruta);
        String line;
        boolean check;
        if (!fichero.exists()){
            try {
                System.out.println("Creando archivo....");
                check = fichero.createNewFile();
                if (check){
                    System.out.println("Ok");
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }else{
            try {
                System.out.println("Cargando phrasal Verbs...");
                BufferedReader br = new BufferedReader(new FileReader(ruta));
                line = br.readLine();
                while (line!=null){
                    phrasal.add(line);
                    line = br.readLine();
                }
                br.close();
                System.out.println("Ok");
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    private static void cargarArchivoEstadisticas(ArrayList<Long> time){
        String ruta = "estadisticas.txt";
        File fichero = new File(ruta);
        String line;
        long timeaux = 0;
        boolean check;
        if (!fichero.exists()){
            try {
                System.out.println("Creando archivo de estadisticas...");
                check = fichero.createNewFile();
                if (check){
                    System.out.println("Ok");
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }else{
            try {
                System.out.println("Cargando estadisticas...");
                BufferedReader br = new BufferedReader(new FileReader(ruta));
                line = br.readLine();
                timeaux = Long.parseLong(line);
                while (line!=null){
                    time.add(timeaux);
                    line = br.readLine();
                }
                br.close();
                System.out.println("Ok");
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    private static void cargarDiccionarios(ArrayList<String> diccionarioIngles, ArrayList<String> diccionarioEspannol){
        String rutaingles = "wordsEnglish.txt";
        String rutaespannol = "palabrasEspañol.txt";
        String aux;
        try {
            System.out.println("Cargando diccionario en ingles...");
            BufferedReader br = new BufferedReader(new FileReader(rutaingles));
            aux = br.readLine();
            while (aux!=null){
                diccionarioIngles.add(aux);
                aux = br.readLine();
            }
            br.close();
            System.out.println("Ok");
        }catch (IOException e){
            e.printStackTrace();
        }
        try {
            System.out.println("Cargando diccionario en español...");
            BufferedReader br = new BufferedReader(new FileReader(rutaespannol));
            aux = br.readLine();
            while (aux!=null){
                diccionarioEspannol.add(aux);
                aux = br.readLine();
            }
            br.close();
            System.out.println("Ok");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    private static void rellenarObjetoPalabra(ArrayList<String> linea, ArrayList<Palabra> paqViajes){
        for (String line : linea){
            Palabra palabra = new Palabra();
            String[] partes = line.split("\\|");
            palabra.setEsp(partes[0]);
            palabra.setIng(partes[1]);
            paqViajes.add(palabra);
        }
    }
    private static void rellenarObjetoPhasal(ArrayList<String> phrasal, ArrayList<PhrasalVerbs> phrasalVerbs){
        for (String line : phrasal){
            PhrasalVerbs phrasalVerbs1 = new PhrasalVerbs();
            String[] partes = line.split("\\|");
            phrasalVerbs1.setEspannol(partes[0]);
            phrasalVerbs1.setIngles(partes[1]);
            phrasalVerbs.add(phrasalVerbs1);
        }
    }
    private static void rellenarPalabras(ArrayList<Palabra> paqViajes){
        String ruta = "palabras.txt";
        String line;
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(ruta, false));
            for (Palabra palabra : paqViajes){
                line = palabra.getEsp()+"|"+palabra.getIng();
                bw.write(line);
                bw.newLine();
            }
            bw.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    private static void rellenarPhrasal(ArrayList<PhrasalVerbs> phrasalVerbs){
        String ruta = "phrasalVerbs.txt";
        String line;
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(ruta, false));
            for (PhrasalVerbs phrasalVerbs1 : phrasalVerbs){
                line = phrasalVerbs1.getEspannol()+"|"+phrasalVerbs1.getIngles();
                bw.write(line);
                bw.newLine();
            }
            bw.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    private static void rellenarEstadisticas(ArrayList<Long> time){
        String ruta = "estadisticas.txt";
        String line;
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(ruta, false));
            for (Long Time : time){
                line = String.valueOf(Time);
                bw.write(line);
                bw.newLine();
            }
            bw.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    ////////////////////***********************************************************************//////////////////////
}
