package proyecto;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Juego {

    JFrame ventana;
    int casillas;
    
    //presentacion
    JPanel panelPresentacion;
    JButton iniciar;
    JLabel fondoPresentacion;
    ImageIcon imagenFondoPres;
    
    //Menu
    JPanel panelMenu;
    JButton botones[];
    JLabel fondoMenu;
    JLabel multijugador;
    ImageIcon imagenFondoMenu;
    
    //Instrucciones
    JPanel panelInstrucciones;
    JButton regresar;
    
    //Jugar
    JPanel panelJugar;
    JButton modoMultijugador[];
    int modo;
    
    //Modo dos jugadores
    JPanel panelDosJugadores;
    JButton personajeDos[];
    boolean mario=false, link=false, crash=false, sonic=false;
    ImageIcon jugador1, jugador2;
    int p1, p2;
    JLabel personajes;
    
    //Modo cuatro jugadores
    JPanel panelCuatroJugadores;
    JButton personajeCuatro[];
    ImageIcon jugador3, jugador4;
    int p3, p4;
    
    //colores 2 jugadores
    JPanel panelColores;
    JButton colores[];
    boolean azul=false, amarillo=false, morado=false, naranja=false;
    ImageIcon color1, color2;
    int c1,c2;
    JLabel Colores;
    int cont1=1, cont2=1;
    
    //colores 4 jugadores
    JPanel panel4Colores;
    JButton colores4[];
    ImageIcon color3, color4;
    JLabel porcentajep1, porcentajep2;
    int c3, c4;
    int cont3=1, cont4=1;
    
    //Juego2
    JPanel panelJuego2;
    
    //juego 4
    JPanel panelJuego4;
    JLabel porcentajep3, porcentajep4;
    
    //tablero
    int mat[][];
    JLabel matriz[][];    
    
    //comodines
    int rnx, rny;
    
    public Juego(){
        ventana= new JFrame("CHASE-SQUARE");
        ventana.setSize(850+9, 860+25);
        ventana.setLayout(null);
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        
        panelPresentacion= new JPanel();
        panelPresentacion.setLayout(null);
        panelPresentacion.setBounds(0,0, ventana.getWidth(), ventana.getHeight());
        panelPresentacion.setVisible(true);
        
        
        iniciar= new JButton("Iniciar");
        iniciar.setBackground(Color.WHITE);
        iniciar.setBounds(ventana.getWidth()-300, 100, 200, 50);
        iniciar.setVisible(true);
        panelPresentacion.add(iniciar,0);
        
        fondoPresentacion= new JLabel();
        fondoPresentacion.setBounds(0, 0, ventana.getWidth(), ventana.getHeight());
        imagenFondoPres= new ImageIcon("Fondo.jpg");
        imagenFondoPres= new ImageIcon(imagenFondoPres.getImage().getScaledInstance(ventana.getWidth(), ventana.getHeight(), Image.SCALE_DEFAULT));
        fondoPresentacion.setIcon(imagenFondoPres);
        fondoPresentacion.setVisible(true);
        panelPresentacion.add(fondoPresentacion,0);
        
        personajes= new JLabel("CHASE-SQUARE");
        personajes.setBounds(50, 100, 700, 40);
        personajes.setForeground(Color.white);
        personajes.setVisible(true);
        personajes.setFont(new java.awt.Font("Tahoma", 0, 40)); 
        panelPresentacion.add(personajes,0);
        
        //menu
        botones= new JButton[3];
        for (int i = 0; i < botones.length; i++) {
            botones[i]= new JButton();
        }
        //Instrucciones
        regresar= new JButton();
        
        //Jugar
        modoMultijugador= new JButton[2];
        for (int i = 0; i < modoMultijugador.length; i++) {
            modoMultijugador[i]= new JButton();
        }
                //Modo dos jugadores
        personajeDos= new JButton[4];
        for (int i = 0; i < personajeDos.length; i++) {
            personajeDos[i]= new JButton();
        }
        
        //colores 2 jugadores
         colores= new JButton[4];
        for (int i = 0; i < colores.length; i++) {
            colores[i]= new JButton();
        }
        
        //colores 4 jugadores
        colores4= new JButton[4];
        for (int i = 0; i < colores4.length; i++) {
            colores4[i]= new JButton();
        }
        
        iniciar.addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent e){
                System.out.println("iniciar");
                menu();
                eventoMenu();
            }
        });
        
        /*
        //Tablero
        mat= new int[casillas][casillas];
        matriz= new JLabel[casillas][casillas];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
               matriz[i][j]=new JLabel(); 
            } 
        }*/
        mat=tablero2(casillas);
        
        ventana.add(panelPresentacion, -1);
        ventana.setVisible(true);
        
    }
    
    public void menu(){
        
        panelPresentacion.setVisible(false);
        panelMenu= new JPanel();
        panelMenu.setLayout(null);
        panelMenu.setBounds(0,0, ventana.getWidth(), ventana.getHeight());
        panelMenu.setVisible(true);
        
        fondoMenu= new JLabel();
        fondoMenu.setBounds(0, 0, ventana.getWidth(), ventana.getHeight());
        imagenFondoMenu= new ImageIcon("Fondo.jpg");
        imagenFondoMenu= new ImageIcon(imagenFondoMenu.getImage().getScaledInstance(ventana.getWidth(), ventana.getHeight(), Image.SCALE_DEFAULT));
        fondoMenu.setIcon(imagenFondoMenu);
        fondoMenu.setVisible(true);
        panelMenu.add(fondoMenu,0);
        
        
        botones[0].setText("Jugar");
        botones[1].setText("Instrucciones");
        botones[2].setText("Salir");
        
        for (int i = 0; i < botones.length; i++) {
            botones[i].setBounds(ventana.getWidth()-300, (1+i)*60, 200, 50);
            botones[i].setVisible(true);
            botones[i].setBackground(Color.white);
            panelMenu.add(botones[i],0); 
        }
        ventana.add(panelMenu);
    }//final menu
    public void eventoMenu(){
    
        botones[0].addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent e){
                System.out.println("Jugar");
                Jugar();
                eventoJugar();
            }
        });
        
        botones[1].addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent e){
                System.out.println("Instrucciones");
                JOptionPane.showMessageDialog(panelMenu, "El juego consiste en crear una plataforma cuadriculada en donde participen uno a cuatro jugadores\n"
                        + " donde tendrán que recorrer la mayor cantidad de cuadrados y se pintara de un color específico \n "
                        + "el jugador que cuente con más recuadros pintados sera el ganador. \n "
                        + "1.deberas ecoger el tipo de juego multijugador \n   1.1 Juego para cuatro jugadores \n   1.2 juego para cuatro jugadores"
                        + "\n 2. Escoge el personaje que mas te agrade \n 3. Escoger tu color favorito \n 4. Las teclas e juego son: \n   "
                        + "4.1 Jugador 1 con flechas \n   4.2 Jugador 2 con las teclas 'W,S,D,A' "
                        + "\n   4.3 Jugador 3 con las teclas´J,K,L,I´ \n   4.4 Jugador 4 con el teclado numerico" );
                
            }
        });
        
        botones[2].addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent e){
                System.out.println("Salir");
                System.exit(0);
            }
        });
    }
    
    public void Jugar(){
        panelPresentacion.setVisible(false);
        panelMenu.setVisible(false);
        panelJugar= new JPanel();
        panelJugar.setLayout(null);
        panelJugar.setBounds(0,0, ventana.getWidth(), ventana.getHeight());
        panelJugar.setVisible(true);
        
        fondoMenu= new JLabel();
        fondoMenu.setBounds(0, 0, ventana.getWidth(), ventana.getHeight());
        imagenFondoMenu= new ImageIcon("Fondo.jpg");
        imagenFondoMenu= new ImageIcon(imagenFondoMenu.getImage().getScaledInstance(ventana.getWidth(), ventana.getHeight(), Image.SCALE_DEFAULT));
        fondoMenu.setIcon(imagenFondoMenu);
        fondoMenu.setVisible(true);
        panelJugar.add(fondoMenu,0);
         
        multijugador= new JLabel("SELECIONE EL MODO MULTIJUGADOR QUE DESEA");
        multijugador.setBounds(20, 100, 700, 30);
        multijugador.setForeground(Color.white);
        multijugador.setVisible(true);
        multijugador.setFont(new java.awt.Font("Tahoma", 0, 28)); 
        panelJugar.add(multijugador,0);
        
        modoMultijugador[0].setText("2 Jugadores");
        modoMultijugador[1].setText("4 Jugadores");
        
        for (int i = 0; i < modoMultijugador.length; i++) {
            modoMultijugador[i].setBounds(ventana.getWidth()-250, 110+(1+i)*60, 200, 50);
            modoMultijugador[i].setVisible(true);
            modoMultijugador[i].setBackground(Color.white);
            panelJugar.add(modoMultijugador[i],0); 
        }
        ventana.add(panelJugar);
    
    }
    public void eventoJugar(){
        
        modoMultijugador[0].addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent e){
                System.out.println("Modo Dos Jugadores");
                modo=2;
                modoDosJugadores();
                eventoDosJugadores();
            }
        });
        
        modoMultijugador[1].addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent e){
                System.out.println("Modo Cuatro Jugadores");
                modo=4;
                modoCuatroJugadores();
                eventoCuatroJugadores();   
            }
        });

    } 
    
    public void modoDosJugadores(){
        
        panelPresentacion.setVisible(false);
        panelMenu.setVisible(false);
        panelJugar.setVisible(false);
        panelDosJugadores= new JPanel();
        panelDosJugadores.setLayout(null);
        panelDosJugadores.setBounds(0,0, ventana.getWidth(), ventana.getHeight());
        panelDosJugadores.setVisible(true);
        
        fondoMenu= new JLabel();
        fondoMenu.setBounds(0, 0, ventana.getWidth(), ventana.getHeight());
        imagenFondoMenu= new ImageIcon("Fondo.jpg");
        imagenFondoMenu= new ImageIcon(imagenFondoMenu.getImage().getScaledInstance(ventana.getWidth(), ventana.getHeight(), Image.SCALE_DEFAULT));
        fondoMenu.setIcon(imagenFondoMenu);
        fondoMenu.setVisible(true);
       panelDosJugadores.add(fondoMenu,0);
       
       personajes= new JLabel("SELECIONE EL PERSONAJE QUE DESEA");
        personajes.setBounds(20, 100, 700, 30);
        personajes.setForeground(Color.white);
        personajes.setVisible(true);
        personajes.setFont(new java.awt.Font("Tahoma", 0, 28)); 
        panelDosJugadores.add(personajes,0);
       
       ImageIcon mario= new ImageIcon("1.png");
       ImageIcon link= new ImageIcon("2.png");
       ImageIcon crash= new ImageIcon("3.png");
       ImageIcon sonic= new ImageIcon("4.png");
        
        personajeDos[0].setIcon(mario);
        personajeDos[1].setIcon(link);
        personajeDos[2].setIcon(crash);
        personajeDos[3].setIcon(sonic);
        
        for (int i = 0; i < personajeDos.length; i++) {
            personajeDos[i].setBounds(ventana.getWidth()-250, (1+i)*90, 80, 80);
            personajeDos[i].setVisible(true);
            personajeDos[i].setBackground(Color.white);
            panelDosJugadores.add(personajeDos[i],0); 
        }
        ventana.add(panelDosJugadores);
    }
    public void eventoDosJugadores(){
       
    
        personajeDos[0].addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent e){
                mario=true;
                if(link==false&& crash==false&& sonic==false){
                jugador1= new ImageIcon("1.png");
                p1=1;
                    System.out.println("el jugador 1 a escogido a mario");
                }else{
                jugador2= new ImageIcon("1.png");
                p2=1;
                    System.out.println("el jugador 2 a escogido a mario");
                colores();
                eventoColoresDosJugadores();
                }
                personajeDos[0].setVisible(false);
            }
        });
        
        personajeDos[1].addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent e){
                link=true;
                if(mario==false&& crash==false&& sonic==false){
                jugador1= new ImageIcon("2.png");
                p1=2;
                System.out.println("el jugador 1 a escogido a link");
                }else{
                jugador2= new ImageIcon("2.png");
                p2=2;
                System.out.println("el jugador 2 a escogido a link");
                colores();
                eventoColoresDosJugadores();
                }
               personajeDos[1].setVisible(false); 
            }
        });
        
        personajeDos[2].addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent e){
                crash=true;
                if(link==false&& mario==false&& sonic==false){
                jugador1= new ImageIcon("3.png");
                p1=3;
                System.out.println("el jugador 1 a escogido a crash");
                }else{
                jugador2= new ImageIcon("3.png");
                p2=3;
                System.out.println("el jugador 2 a escogido a crash");
                colores();
                eventoColoresDosJugadores();
                }
                personajeDos[2].setVisible(false);
            }
        });
        personajeDos[3].addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent e){
                sonic=true;
                if(link==false&& crash==false&& mario==false){
                jugador1= new ImageIcon("4.png");
                p1=4;
                System.out.println("el jugador 1 a escogido a sonic");
                }else{
                jugador2= new ImageIcon("4.png");
                p2=4;
                System.out.println("el jugador 2 a escogido a sonic");
                colores();
                eventoColoresDosJugadores();
                }
                personajeDos[3].setVisible(false);
            }
        });
    }
    
    public void colores(){
        panelPresentacion.setVisible(false);
        panelMenu.setVisible(false);
        panelDosJugadores.setVisible(false);
        panelJugar.setVisible(false);
        panelColores= new JPanel();
        panelColores.setLayout(null);
        panelColores.setBounds(0,0, ventana.getWidth(), ventana.getHeight());
        panelColores.setVisible(true);
        
        fondoMenu= new JLabel();
        fondoMenu.setBounds(0, 0, ventana.getWidth(), ventana.getHeight());
        imagenFondoMenu= new ImageIcon("Fondo.jpg");
        imagenFondoMenu= new ImageIcon(imagenFondoMenu.getImage().getScaledInstance(ventana.getWidth(), ventana.getHeight(), Image.SCALE_DEFAULT));
        fondoMenu.setIcon(imagenFondoMenu);
        fondoMenu.setVisible(true);
       panelColores.add(fondoMenu,0);
       
       Colores= new JLabel("SELECIONE EL COLOR QUE DESEA");
        Colores.setBounds(20, 100, 700, 30);
        Colores.setForeground(Color.white);
        Colores.setVisible(true);
        Colores.setFont(new java.awt.Font("Tahoma", 0, 28)); 
        panelColores.add(Colores,0);
       
       ImageIcon azul= new ImageIcon("5.png");
       ImageIcon amarillo= new ImageIcon("6.png");
       ImageIcon naranja= new ImageIcon("8.png");
       ImageIcon morado= new ImageIcon("7.png");
        
        colores[0].setIcon(azul);
        colores[1].setIcon(amarillo);
        colores[2].setIcon(naranja);
        colores[3].setIcon(morado);
        
        for (int i = 0; i < colores.length; i++) {
            colores[i].setBounds(ventana.getWidth()-250, (1+i)*90, 80, 80);
            colores[i].setVisible(true);
            colores[i].setBackground(Color.white);
            panelColores.add(colores[i],0); 
        }
        ventana.add(panelColores);
    }
    public void eventoColoresDosJugadores() {
       
    
        colores[0].addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent e){
                azul=true;
                if(amarillo==false&& morado==false&& naranja==false){
                color1= new ImageIcon("5.png");
                c1=5;
                    System.out.println("el jugador 1 a escogido el color azul");
                }else{
                color2= new ImageIcon("5.png");
                c2=5;
                    System.out.println("el jugador 2 a escogido el color azul");
                    casillas= Integer.parseInt(JOptionPane.showInputDialog(ventana,"numero de casillas con las que desea jugar", "ingrese aqui"));
                    System.out.println("el numero de casillas escogido es: "+casillas);
                    while(casillas<5||casillas>10){
                        System.out.println("ERROR: supero el limite de casillas");
                    JOptionPane.showMessageDialog(panelColores, "el numero de casillas debe estar entre 5 y 10");
                    casillas= Integer.parseInt(JOptionPane.showInputDialog(ventana,"numero de casillas con las que desea jugar", "ingrese aqui"));
                    System.out.println("el numero de casillas escogido es: "+casillas);
                    }
                    jugar2();
                }
                colores[0].setVisible(false);
            }
        });
        
        colores[1].addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent e){
                amarillo=true;
                if(azul==false&& morado==false&& naranja==false){
                color1= new ImageIcon("6.png");
                c1=6;
                System.out.println("el jugador 1 a escogido el color amarillo");
                }else{
                color2= new ImageIcon("6.png");
                c2=6;
                System.out.println("el jugador 2 a escogido el color amarillo");
                casillas= Integer.parseInt(JOptionPane.showInputDialog(ventana,"numero de casillas con las que desea jugar", "ingrese aqui"));
                    System.out.println("el numero de casillas escogido es: "+casillas);
                    while(casillas<5||casillas>10){
                        System.out.println("ERROR: supero el limite de casillas");
                    JOptionPane.showMessageDialog(panelColores, "el numero de casillas debe estar entre 5 y 10");
                    casillas= Integer.parseInt(JOptionPane.showInputDialog(ventana,"numero de casillas con las que desea jugar", "ingrese aqui"));
                    System.out.println("el numero de casillas escogido es: "+casillas);
                    }
                   jugar2(); 
                } 
                colores[1].setVisible(false);
            }
        });
        
        colores[2].addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent e){
                naranja=true;
                if(amarillo==false&& morado==false&& azul==false){
                color1= new ImageIcon("8.png");
                c1=8;
                System.out.println("el jugador 1 a escogido el color naranja");
                }else{
                color2= new ImageIcon("8.png");
                c2=8;
                System.out.println("el jugador 2 a escogido el color naranja");
                casillas= Integer.parseInt(JOptionPane.showInputDialog(ventana,"numero de casillas con las que desea jugar", "ingrese aqui"));
                    System.out.println("el numero de casillas escogido es: "+casillas);
                    while(casillas<5||casillas>10){
                        System.out.println("ERROR: supero el limite de casillas");
                    JOptionPane.showMessageDialog(panelColores, "el numero de casillas debe estar entre 5 y 10");
                    casillas= Integer.parseInt(JOptionPane.showInputDialog(ventana,"numero de casillas con las que desea jugar", "ingrese aqui"));
                    System.out.println("el numero de casillas escogido es: "+casillas);
                    }
                jugar2();
                }
                colores[2].setVisible(false);
            }
        });
        colores[3].addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent e){
                morado=true;
                if(amarillo==false&& azul==false&& naranja==false){
                color1= new ImageIcon("7.png");
                c1=7;
                System.out.println("el jugador 1 a escogido el color morado");
                }else{
                color2= new ImageIcon("7.png");
                c2=7;
                System.out.println("el jugador 2 a escogido el color morado");
                casillas= Integer.parseInt(JOptionPane.showInputDialog(ventana,"numero de casillas con las que desea jugar", "ingrese aqui"));
                    System.out.println("el numero de casillas escogido es: "+casillas);
                    while(casillas<5||casillas>10){
                        System.out.println("ERROR: supero el limite de casillas");
                    JOptionPane.showMessageDialog(panelColores, "el numero de casillas debe estar entre 5 y 10");
                    casillas= Integer.parseInt(JOptionPane.showInputDialog(ventana,"numero de casillas con las que desea jugar", "ingrese aqui"));
                    System.out.println("el numero de casillas escogido es: "+casillas);
                    }
                jugar2();
                
                }
                colores[3].setVisible(false);
            }
        }); 
    }
    
    public void modoCuatroJugadores(){
        
    panelPresentacion.setVisible(false);
        panelMenu.setVisible(false);
        panelJugar.setVisible(false);
        panelCuatroJugadores= new JPanel();
        panelCuatroJugadores.setLayout(null);
        panelCuatroJugadores.setBounds(0,0, ventana.getWidth(), ventana.getHeight());
        panelCuatroJugadores.setVisible(true);
        
        fondoMenu= new JLabel();
        fondoMenu.setBounds(0, 0, ventana.getWidth(), ventana.getHeight());
        imagenFondoMenu= new ImageIcon("Fondo.jpg");
        imagenFondoMenu= new ImageIcon(imagenFondoMenu.getImage().getScaledInstance(ventana.getWidth(), ventana.getHeight(), Image.SCALE_DEFAULT));
        fondoMenu.setIcon(imagenFondoMenu);
        fondoMenu.setVisible(true);
       panelCuatroJugadores.add(fondoMenu,0);
       
       personajes= new JLabel("SELECIONE EL PERSONAJE QUE DESEA");
        personajes.setBounds(20, 100, 700, 30);
        personajes.setForeground(Color.white);
        personajes.setVisible(true);
        personajes.setFont(new java.awt.Font("Tahoma", 0, 28)); 
        panelCuatroJugadores.add(personajes,0);
       
       ImageIcon mario= new ImageIcon("1.png");
       ImageIcon link= new ImageIcon("2.png");
       ImageIcon crash= new ImageIcon("3.png");
       ImageIcon sonic= new ImageIcon("4.png");
        
        personajeDos[0].setIcon(mario);
        personajeDos[1].setIcon(link);
        personajeDos[2].setIcon(crash);
        personajeDos[3].setIcon(sonic);
        
        for (int i = 0; i < personajeDos.length; i++) {
            personajeDos[i].setBounds(ventana.getWidth()-250, (1+i)*90, 80, 80);
            personajeDos[i].setVisible(true);
            personajeDos[i].setBackground(Color.white);
            panelCuatroJugadores.add(personajeDos[i],0); 
        }
        ventana.add(panelCuatroJugadores);}
    public void eventoCuatroJugadores(){
       
        personajeDos[0].addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent e){
                mario=true;
                if(link==false&& crash==false&& sonic==false){
                jugador1= new ImageIcon("1.png");
                p1=1;
                    System.out.println("el jugador 1 a escogido a mario");
                }
                if((link==false&& crash==false&& sonic==true)||(link==false&& crash==true&& sonic==false)||(link==true&& crash==false&& sonic==false)){
                jugador2= new ImageIcon("1.png");
                p2=1;
                    System.out.println("el jugador 2 a escogido a mario");
                }
                if((link==false&& crash==true&& sonic==true)||(link==true&& crash==true&& sonic==false)||(link==true&& crash==false&& sonic==true)){
                jugador3= new ImageIcon("1.png");
                p3=1;
                    System.out.println("el jugador 3 a escogido a mario");
                }
                if(link==true&& crash==true&& sonic==true){
                jugador4= new ImageIcon("1.png");
                    System.out.println("el jugador 4 a escogido a mario");
                colores4();
                p4=1;
                eventoColoresCuatroJugadores();
                }
               personajeDos[0].setVisible(false); 
            }
        });
        
        personajeDos[1].addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent e){
                link=true;
                if(mario==false&& crash==false&& sonic==false){
                jugador1= new ImageIcon("2.png");
                p1=2;
                    System.out.println("el jugador 1 a escogido a link");
                }
                if((mario==false&& crash==false&& sonic==true)||(mario==false&& crash==true&& sonic==false)||(mario==true&& crash==false&& sonic==false)){
                jugador2= new ImageIcon("2.png");
                p2=2;
                    System.out.println("el jugador 2 a escogido a link");
                }
                if((mario==false&& crash==true&& sonic==true)||(mario==true&& crash==true&& sonic==false)||(mario==true&& crash==false&& sonic==true)){
                jugador3= new ImageIcon("2.png");
                p3=2;
                    System.out.println("el jugador 3 a escogido a link");
                }
                if(mario==true&& crash==true&& sonic==true){
                jugador4= new ImageIcon("2.png");
                p4=2;
                    System.out.println("el jugador 4 a escogido a link");
                colores4();
                eventoColoresCuatroJugadores();
                }
                personajeDos[1].setVisible(false);
            }
        });
        
        personajeDos[2].addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent e){
                crash=true;
                if(link==false&& mario==false&& sonic==false){
                jugador1= new ImageIcon("3.png");
                p1=3;
                    System.out.println("el jugador 1 a escogido a crash");
                }
                if((link==false&& mario==false&& sonic==true)||(link==false&& mario==true&& sonic==false)||(link==true&& mario==false&& sonic==false)){
                jugador2= new ImageIcon("3.png");
                p2=3;
                    System.out.println("el jugador 2 a escogido a crash");
                }
                if((link==false&& mario==true&& sonic==true)||(link==true&& mario==true&& sonic==false)||(link==true&& mario==false&& sonic==true)){
                jugador3= new ImageIcon("3.png");
                p3=3;
                    System.out.println("el jugador 3 a escogido a crash");
                }
                if(link==true&& mario==true&& sonic==true){
                jugador4= new ImageIcon("3.png");
                p4=3;
                    System.out.println("el jugador 4 a escogido a crash");
                colores4();
                eventoColoresCuatroJugadores();
                }
                personajeDos[2].setVisible(false);
            }
        });
        personajeDos[3].addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent e){
                sonic=true;
                if(link==false&& crash==false&& mario==false){
                jugador1= new ImageIcon("4.png");
                p1=4;
                    System.out.println("el jugador 1 a escogido a sonic");
                }
                if((link==false&& crash==false&&mario==true)||(link==false&& crash==true&& mario==false)||(link==true&& crash==false&& mario==false)){
                jugador2= new ImageIcon("4.png");
                p2=4;
                    System.out.println("el jugador 2 a escogido a sonic");
                }
                if((link==false&& crash==true&& mario==true)||(link==true&& crash==true&& mario==false)||(link==true&& crash==false&& mario==true)){
                jugador3= new ImageIcon("4.png");
                p3=4;
                    System.out.println("el jugador 3 a escogido a sonic");
                }
                if(link==true&& crash==true&& mario==true){
                jugador4= new ImageIcon("4.png");
                p4=4;
                    System.out.println("el jugador 4 a escogido a sonic");
                colores4();
                eventoColoresCuatroJugadores();
                }
                personajeDos[3].setVisible(false);
            }
        });
    }
    
    public void colores4(){
        panelPresentacion.setVisible(false);
        panelMenu.setVisible(false);
        panelCuatroJugadores.setVisible(false);
        panelJugar.setVisible(false);
        panel4Colores= new JPanel();
        panel4Colores.setLayout(null);
        panel4Colores.setBounds(0,0, ventana.getWidth(), ventana.getHeight());
        panel4Colores.setVisible(true);
        
        fondoMenu= new JLabel();
        fondoMenu.setBounds(0, 0, ventana.getWidth(), ventana.getHeight());
        imagenFondoMenu= new ImageIcon("Fondo.jpg");
        imagenFondoMenu= new ImageIcon(imagenFondoMenu.getImage().getScaledInstance(ventana.getWidth(), ventana.getHeight(), Image.SCALE_DEFAULT));
        fondoMenu.setIcon(imagenFondoMenu);
        fondoMenu.setVisible(true);
       panel4Colores.add(fondoMenu,0);
       
       Colores= new JLabel("SELECIONE EL COLOR QUE DESEA");
        Colores.setBounds(20, 100, 700, 30);
        Colores.setForeground(Color.white);
        Colores.setVisible(true);
        Colores.setFont(new java.awt.Font("Tahoma", 0, 28)); 
        panel4Colores.add(Colores,0);
       
       ImageIcon azul= new ImageIcon("5.png");
       ImageIcon amarillo= new ImageIcon("6.png");
       ImageIcon naranja= new ImageIcon("8.png");
       ImageIcon morado= new ImageIcon("7.png");
        
        colores4[0].setIcon(azul);
        colores4[1].setIcon(amarillo);
        colores4[2].setIcon(naranja);
        colores4[3].setIcon(morado);
        
        for (int i = 0; i < colores4.length; i++) {
            colores4[i].setBounds(ventana.getWidth()-250, (1+i)*90, 80, 80);
            colores4[i].setVisible(true);
            colores4[i].setBackground(Color.white);
            panel4Colores.add(colores4[i],0); 
        }
        ventana.add(panel4Colores);
    }
    public void eventoColoresCuatroJugadores(){
       
    
        colores4[0].addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent e){
                azul=true;
                if(amarillo==false&& morado==false&& naranja==false){
                color1= new ImageIcon("5.png");
                c1=5;
                    System.out.println("el jugador 1 a escogido el color azul");
                }
                if((amarillo==false&& morado==false&& naranja==true)||(amarillo==false&& morado==true&& naranja==false)||(amarillo==true&& morado==false&& naranja==false)){
                color2= new ImageIcon("5.png");
                c2=5;
                    System.out.println("el jugador 2 a escogido el color azul");
                }
                if((amarillo==false&& morado==true&& naranja==true)||(amarillo==true&& morado==true&& naranja==false)||(amarillo==true&& morado==false&& naranja==true)){
                color3= new ImageIcon("5.png");
                c3=5;
                    System.out.println("el jugador 3 a escogido el color azul");
                }
                if(amarillo==true&& morado==true&& naranja==true){
                color4= new ImageIcon("5.png");
                c4=5;
                    System.out.println("el jugador 4 a escogido el color azul");
                    casillas= Integer.parseInt(JOptionPane.showInputDialog(ventana,"numero de casillas con las que desea jugar", "ingrese aqui"));
                    System.out.println("el numero de casillas escogido es: "+casillas);
                    while(casillas<5||casillas>10){
                        System.out.println("ERROR: supero el limite de casillas");
                    JOptionPane.showMessageDialog(panelColores, "el numero de casillas debe estar entre 5 y 10");
                    casillas= Integer.parseInt(JOptionPane.showInputDialog(ventana,"numero de casillas con las que desea jugar", "ingrese aqui"));
                    System.out.println("el numero de casillas escogido es: "+casillas);
                    }
                    jugar4();
                }
                colores4[0].setVisible(false);
            }
        });
        
        colores4[1].addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent e){
                amarillo=true;
                if(azul==false&& morado==false&& naranja==false){
                color1= new ImageIcon("6.png");
                c1=6;
                    System.out.println("el jugador 1 a escogido el color amarillo");
                }
                if((azul==false&& morado==false&& naranja==true)||(azul==false&& morado==true&& naranja==false)||(azul==true&& morado==false&& naranja==false)){
                color2= new ImageIcon("6.png");
                c2=6;
                    System.out.println("el jugador 2 a escogido el color amarillo");
                }
                if((azul==false&& morado==true&& naranja==true)||(azul==true&& morado==true&& naranja==false)||(azul==true&& morado==false&& naranja==true)){
                color3= new ImageIcon("6.png");
                c3=6;
                    System.out.println("el jugador 3 a escogido el color amarillo");
                }
                if(azul==true&& morado==true&& naranja==true){
                color4= new ImageIcon("6.png");
                c4=6;
                    System.out.println("el jugador 4 a escogido el color amarillo");
                    casillas= Integer.parseInt(JOptionPane.showInputDialog(ventana,"numero de casillas con las que desea jugar", "ingrese aqui"));
                    System.out.println("el numero de casillas escogido es: "+casillas);
                    while(casillas<5||casillas>10){
                        System.out.println("ERROR: supero el limite de casillas");
                    JOptionPane.showMessageDialog(panelColores, "el numero de casillas debe estar entre 5 y 10");
                    casillas= Integer.parseInt(JOptionPane.showInputDialog(ventana,"numero de casillas con las que desea jugar", "ingrese aqui"));
                    System.out.println("el numero de casillas escogido es: "+casillas);
                    }
                    jugar4();
                }
                colores4[1].setVisible(false);
            }
        });
        
        colores4[2].addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent e){
                naranja=true;
                if(amarillo==false&& morado==false&& azul==false){
                color1= new ImageIcon("8.png");
                c1=8;
                    System.out.println("el jugador 1 a escogido el color naranja");
                }
                if((amarillo==false&& morado==false&& azul==true)||(amarillo==false&& morado==true&& azul==false)||(amarillo==true&& morado==false&& azul==false)){
                color2= new ImageIcon("8.png");
                c2=8;
                    System.out.println("el jugador 2 a escogido el color naranja");
                }
                if((amarillo==false&& morado==true&& azul==true)||(amarillo==true&& morado==true&& azul==false)||(amarillo==true&& morado==false&& azul==true)){
                color3= new ImageIcon("8.png");
                c3=8;
                    System.out.println("el jugador 3 a escogido el color naranja");
                }
                if(amarillo==true&& morado==true&& azul==true){
                color4= new ImageIcon("8.png");
                c4=8;
                    System.out.println("el jugador 4 a escogido el color naranja");
                    casillas= Integer.parseInt(JOptionPane.showInputDialog(ventana,"numero de casillas con las que desea jugar", "ingrese aqui"));
                    System.out.println("el numero de casillas escogido es: "+casillas);
                    while(casillas<5||casillas>10){
                        System.out.println("ERROR: supero el limite de casillas");
                    JOptionPane.showMessageDialog(panelColores, "el numero de casillas debe estar entre 5 y 10");
                    casillas= Integer.parseInt(JOptionPane.showInputDialog(ventana,"numero de casillas con las que desea jugar", "ingrese aqui"));
                    System.out.println("el numero de casillas escogido es: "+casillas);
                    }
                    jugar4();
                }
                colores4[2].setVisible(false);
            }
        });
        
        colores4[3].addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent e){
                morado=true;
                if(amarillo==false&& azul==false&& naranja==false){
                color1= new ImageIcon("7.png");
                c1=7;
                    System.out.println("el jugador 1 a escogido el color morado");
                }
                if((amarillo==false&& azul==false&& naranja==true)||(amarillo==false&& azul==true&& naranja==false)||(amarillo==true&& azul==false&& naranja==false)){
                color2= new ImageIcon("7.png");
                c2=7;
                    System.out.println("el jugador 2 a escogido el color morado");
                }
                if((amarillo==false&& azul==true&& naranja==true)||(amarillo==true&& azul==true&& naranja==false)||(amarillo==true&& azul==false&& naranja==true)){
                color3= new ImageIcon("7.png");
                c3=7;
                    System.out.println("el jugador 3 a escogido el color morado");
                }
                if(amarillo==true&& azul==true&& naranja==true){
                color4= new ImageIcon("7.png");
                c4=7;
                    System.out.println("el jugador 4 a escogido el color morado");
                    casillas= Integer.parseInt(JOptionPane.showInputDialog(ventana,"numero de casillas con las que desea jugar", "ingrese aqui"));
                    System.out.println("el numero de casillas escogido es: "+casillas);
                    while(casillas<5||casillas>10){
                        System.out.println("ERROR: supero el limite de casillas");
                    JOptionPane.showMessageDialog(panelColores, "el numero de casillas debe estar entre 5 y 10");
                    casillas= Integer.parseInt(JOptionPane.showInputDialog(ventana,"numero de casillas con las que desea jugar", "ingrese aqui"));
                    System.out.println("el numero de casillas escogido es: "+casillas);
                    }
                    jugar4();
                }
                colores4[3].setVisible(false);
            }
        });
    }

    public void jugar2(){
        
        panelPresentacion.setVisible(false);
        panelMenu.setVisible(false);
        panelDosJugadores.setVisible(false);
        panelColores.setVisible(false);
        panelJugar.setVisible(false);
        panelJuego2= new JPanel();
        panelJuego2.setLayout(null);
        panelJuego2.setBounds(0,0, ventana.getWidth(), ventana.getHeight());
        panelJuego2.setVisible(true);
        
        fondoMenu= new JLabel();
        fondoMenu.setBounds(0, 0, ventana.getWidth(), ventana.getHeight());
        imagenFondoMenu= new ImageIcon("Fondo.jpg");
        imagenFondoMenu= new ImageIcon(imagenFondoMenu.getImage().getScaledInstance(ventana.getWidth(), ventana.getHeight(), Image.SCALE_DEFAULT));
        fondoMenu.setIcon(imagenFondoMenu);
        fondoMenu.setVisible(true);
       panelJuego2.add(fondoMenu,0);

       //Tablero
        mat= new int[casillas][casillas];
        matriz= new JLabel[casillas][casillas];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
               matriz[i][j]=new JLabel(); 
            } 
        }
        mat=tablero2(casillas);
        
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
               matriz[i][j].setIcon(new ImageIcon(mat[i][j]+".png"));
               matriz[i][j].setBounds(35+(i*80),35+(j*80), 80, 80);
               matriz[i][j].setVisible(true);
               panelJuego2.add(matriz[i][j],0);
            } 
        }
        
        porcentajep1= new JLabel("Porcentaje jugador1: ");
        porcentajep1.setBounds(10, 5, 400, 20);
        porcentajep1.setForeground(Color.white);
        porcentajep1.setVisible(true);
        porcentajep1.setFont(new java.awt.Font("Tahoma", 0, 16)); 
        panelJuego2.add(porcentajep1,0);
        
        porcentajep2= new JLabel("Porcentaje jugador2: ");
        porcentajep2.setBounds(600, 5, 400, 20);
        porcentajep2.setForeground(Color.white);
        porcentajep2.setVisible(true);
        porcentajep2.setFont(new java.awt.Font("Tahoma", 0, 16)); 
        panelJuego2.add(porcentajep2,0);
        
        moverp1();
        moverp2();
        comodines();
        
    ventana.add(panelJuego2);
    }
    public int[][] tablero2(int casillas){
        
        casillas=this.casillas;
        int aux1[][]=new int[casillas][casillas];

        if(casillas==5){
        int aux[][]={
                {p1,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,p2}
        };
        return aux;
        }
        if(casillas==6){
        int aux[][]={
                {p1,0,0,0,0,0},
                {0,0,0,0,0,0},
                {0,0,0,0,0,0},
                {0,0,0,0,0,0},
                {0,0,0,0,0,0},
                {0,0,0,0,0,p2}
        };
        return aux;
        }
        if(casillas==7){
        int aux[][]={
                {p1,0,0,0,0,0,0},
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,p2}
        };
        return aux;
        }if(casillas==8){
        int aux[][]={
                {p1,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,p2}
        };
        return aux;
        }if(casillas==9){
        int aux[][]={
                {p1,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,p2}
        };
        return aux;
        }if(casillas==10){
        int aux[][]={
                {p1,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,p2}
        };
        return aux;
        }
        return aux1;
    }
    
    public void jugar4(){
        panelPresentacion.setVisible(false);
        panelMenu.setVisible(false);
        panelCuatroJugadores.setVisible(false);
        panel4Colores.setVisible(false);
        panelJugar.setVisible(false);
        panelJuego4= new JPanel();
        panelJuego4.setLayout(null);
        panelJuego4.setBounds(0,0, ventana.getWidth(), ventana.getHeight());
        panelJuego4.setVisible(true);
        
        fondoMenu= new JLabel();
        fondoMenu.setBounds(0, 0, ventana.getWidth(), ventana.getHeight());
        imagenFondoMenu= new ImageIcon("Fondo.jpg");
        imagenFondoMenu= new ImageIcon(imagenFondoMenu.getImage().getScaledInstance(ventana.getWidth(), ventana.getHeight(), Image.SCALE_DEFAULT));
        fondoMenu.setIcon(imagenFondoMenu);
        fondoMenu.setVisible(true);
       panelJuego4.add(fondoMenu,0);

       //Tablero
        mat= new int[casillas][casillas];
        matriz= new JLabel[casillas][casillas];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
               matriz[i][j]=new JLabel(); 
            } 
        }
        mat=tablero4(casillas);
        
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
               matriz[i][j].setIcon(new ImageIcon(mat[i][j]+".png"));
               matriz[i][j].setBounds(35+(i*80),35+(j*80), 80, 80);
               matriz[i][j].setVisible(true);
               panelJuego4.add(matriz[i][j],0);
            } 
        }
        porcentajep1= new JLabel("Porcentaje jugador1: ");
        porcentajep1.setBounds(10, 5, 400, 20);
        porcentajep1.setForeground(Color.white);
        porcentajep1.setVisible(true);
        porcentajep1.setFont(new java.awt.Font("Tahoma", 0, 16)); 
        panelJuego4.add(porcentajep1,0);
        
        porcentajep2= new JLabel("Porcentaje jugador2: ");
        porcentajep2.setBounds(600, 5, 400, 20);
        porcentajep2.setForeground(Color.white);
        porcentajep2.setVisible(true);
        porcentajep2.setFont(new java.awt.Font("Tahoma", 0, 16)); 
        panelJuego4.add(porcentajep2,0);
        
        porcentajep3= new JLabel("Porcentaje jugador3: ");
        porcentajep3.setBounds(10, 833, 400, 20);
        porcentajep3.setForeground(Color.white);
        porcentajep3.setVisible(true);
        porcentajep3.setFont(new java.awt.Font("Tahoma", 0, 16)); 
        panelJuego4.add(porcentajep3,0);
        
        porcentajep4= new JLabel("Porcentaje jugador4: ");
        porcentajep4.setBounds(600, 833, 400, 20);
        porcentajep4.setForeground(Color.white);
        porcentajep4.setVisible(true);
        porcentajep4.setFont(new java.awt.Font("Tahoma", 0, 16)); 
        panelJuego4.add(porcentajep4,0);
        
        moverp1();
        moverp2();
        moverp3();
        moverp4();
        comodines();
        Finalizar();
    ventana.add(panelJuego4);
    }    
    public int[][] tablero4(int casillas){
    casillas=this.casillas;
        int aux1[][]=new int[casillas][casillas];

        if(casillas==5){
        int aux[][]={
                {p1,0,0,0,p4},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {p3,0,0,0,p2}
        };
        return aux;
        }
        if(casillas==6){
        int aux[][]={
                {p1,0,0,0,0,p4},
                {0,0,0,0,0,0},
                {0,0,0,0,0,0},
                {0,0,0,0,0,0},
                {0,0,0,0,0,0},
                {p3,0,0,0,0,p2}
        };
        return aux;
        }
        if(casillas==7){
        int aux[][]={
                {p1,0,0,0,0,0,p4},
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0},
                {p3,0,0,0,0,0,p2}
        };
        return aux;
        }if(casillas==8){
        int aux[][]={
                {p1,0,0,0,0,0,0,p4},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {p3,0,0,0,0,0,0,p2}
        };
        return aux;
        }if(casillas==9){
        int aux[][]={
                {p1,0,0,0,0,0,0,0,p4},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {p3,0,0,0,0,0,0,0,p2}
        };
        return aux;
        }if(casillas==10){
        int aux[][]={
                {p1,0,0,0,0,0,0,0,0,p4},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {p3,0,0,0,0,0,0,0,0,p2}
        };
        return aux;
        }
        return aux1;
    }
    
    //Posiciones
    int dx1=0, dx2, dx3, dx4=0;
    int dy1=0, dy2, dy3=0, dy4;
    
   
    public void pintarMatriz(){
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
               matriz[i][j].setIcon(new ImageIcon(mat[i][j]+".png"));
               matriz[i][j].setBounds(35+(i*80),35+(j*80), 80, 80);
               matriz[i][j].setVisible(true);
               panelJuego2.add(matriz[i][j],0);
            } 
        }
    }   
    public void pintarMatriz4(){
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
               matriz[i][j].setIcon(new ImageIcon(mat[i][j]+".png"));
               matriz[i][j].setBounds(35+(i*80),35+(j*80), 80, 80);
               matriz[i][j].setVisible(true);
               panelJuego4.add(matriz[i][j],0);
            } 
        }
    }
    
    public void comodines(){

        Random rn1 = new Random();
        Random rn2 = new Random();
        rnx= (int)(rn1.nextDouble() * casillas-1);
        rny= (int)(rn2.nextDouble() * casillas-1);
        
        Random rn= new Random();
        int rnc= (int)(rn.nextDouble() * 2);
        if(rnc==0){
            mat[rnx][rny]=9;
        }
        if(rnc==1){
            mat[rnx][rny]=10;
        }
    }
    double porcentaje;
    public void moverp1(){
        switch(casillas){
    case 5:
    dx2=4; dy2=4; dx3=4; dy4=4;
    porcentaje=4;
    break;
    case 6:
    dx2=5; dy2=5; dx3=5; dy4=5;
    porcentaje=2.77;
    break;
    case 7:
    dx2=6; dy2=6; dx3=6; dy4=6;
    porcentaje=2.04;
    break;
    case 8:
    dx2=7; dy2=7; dx3=7; dy4=7;
    porcentaje=1.56;
    break;
    case 9:
    dx2=8; dy2=8; dx3=8; dy4=8;
    porcentaje=1.23;
    break;
    case 10:
    dx2=9; dy2=9; dx3=9; dy4=9;
    porcentaje=1;
    break;    
}
        
        System.out.println(porcentaje);
            ventana.addKeyListener(new KeyListener() {
                
                @Override
                public void keyTyped(KeyEvent e) {
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void keyPressed(KeyEvent e) {
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    try{
                    if(e.getKeyCode()==KeyEvent.VK_UP){
                        System.out.println("Movimiento hacia arriba");
                        if(dy1>=0&&dy1<=casillas-1){
                        if(mat[dx1][dy1-1]!=c1){
                        cont1=cont1+1;}
                            if(mat[dx1][dy1-1]==c2){
                            cont2-=1;
                            }
                            if(mat[dx1][dy1-1]==c3){
                            cont3-=1;
                            }
                            if(mat[dx1][dy1-1]==c4){
                            cont4-=1;
                            }
                        mat[dx1][dy1]=c1;
                        dy1=dy1-1;
                        mat[dx1][dy1]=p1;
                        }
                        colisionComodines1();
                        if(modo==2){
                        pintarMatriz();
                        }
                        if(modo==4){
                        pintarMatriz4();
                        }
                        if(cont1*porcentaje>100){
                        porcentajep1.setText("Porcentaje jugador1: 100%");
                        }else{
                        porcentajep1.setText("Porcentaje jugador1: "+(cont1*porcentaje)+"%");
                        }
                    }
                    if(e.getKeyCode()==KeyEvent.VK_DOWN){
                        System.out.println("Movimiento hacia abajo");
                        if(dy1>=0&&dy1<=casillas-1){
                        if(mat[dx1][dy1+1]!=c1){
                        cont1=cont1+1;}
                        if(mat[dx1][dy1+1]==c2){
                            cont2-=1;
                            }
                            if(mat[dx1][dy1+1]==c3){
                            cont3-=1;
                            }
                            if(mat[dx1][dy1+1]==c4){
                            cont4-=1;
                            }
                        mat[dx1][dy1]=c1;
                        dy1=dy1+1;
                        mat[dx1][dy1]=p1;
                        }
                        colisionComodines1();
                        if(modo==2){
                        pintarMatriz();
                        }
                        if(modo==4){
                        pintarMatriz4();
                        }
                        if(cont1*porcentaje>100){
                        porcentajep1.setText("Porcentaje jugador1: 100%");
                        }else{
                        porcentajep1.setText("Porcentaje jugador1: "+cont1*porcentaje+"%");
                        }
                    }
                    if(e.getKeyCode()==KeyEvent.VK_LEFT){
                        System.out.println("Movimiento hacia la izquierda");
                        if(dx1>=0&&dx1<=casillas-1){
                        if(mat[dx1-1][dy1]!=c1){
                        cont1=cont1+1;}
                        if(mat[dx1-1][dy1]==c2){
                            cont2-=1;
                            }
                            if(mat[dx1-1][dy1]==c3){
                            cont3-=1;
                            }
                            if(mat[dx1-1][dy1]==c4){
                            cont4-=1;
                            }
                        mat[dx1][dy1]=c1;
                        dx1=dx1-1;
                        mat[dx1][dy1]=p1;
                        }
                        colisionComodines1();
                        if(modo==2){
                        pintarMatriz();
                        }
                        if(modo==4){
                        pintarMatriz4();
                        }
                        if(cont1*porcentaje>100){
                        porcentajep1.setText("Porcentaje jugador1: 100%");
                        }else{
                        porcentajep1.setText("Porcentaje jugador1: "+cont1*porcentaje+"%");
                        }
                    }
                    if(e.getKeyCode()==KeyEvent.VK_RIGHT){
                        System.out.println("Movimiento hacia la derecha");
                        if(dx1>=0&&dx1<=casillas-1){
                        if(mat[dx1+1][dy1]!=c1){
                        cont1=cont1+1;}
                        if(mat[dx1+1][dy1]==c2){
                            cont2-=1;
                            }
                            if(mat[dx1+1][dy1]==c3){
                            cont3-=1;
                            }
                            if(mat[dx1+1][dy1]==c4){
                            cont4-=1;
                            }
                        mat[dx1][dy1]=c1;
                        dx1=dx1+1;
                        mat[dx1][dy1]=p1;
                        }
                        colisionComodines1();
                        if(modo==2){
                        pintarMatriz();
                        }
                        if(modo==4){
                        pintarMatriz4();
                        }
                        if(cont1*porcentaje>100){
                        porcentajep1.setText("Porcentaje jugador1: 100%");
                        }else{
                        porcentajep1.setText("Porcentaje jugador1: "+cont1*porcentaje+"%");
                        }
                    }
                    }
                    catch(java.lang.ArrayIndexOutOfBoundsException a){
                        System.out.println("No se puede jugar fuera de la matriz");
                    }
                }

                @Override
                public void keyReleased(KeyEvent e) {
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            });
            Finalizar();
    }
    public void moverp2(){
        switch(casillas){
    case 5:
    dx2=4; dy2=4; dx3=4; dy4=4;
    porcentaje=4;
    break;
    case 6:
    dx2=5; dy2=5; dx3=5; dy4=5;
    porcentaje=2.77;
    break;
    case 7:
    dx2=6; dy2=6; dx3=6; dy4=6;
    porcentaje=2.04;
    break;
    case 8:
    dx2=7; dy2=7; dx3=7; dy4=7;
    porcentaje=1.56;
    break;
    case 9:
    dx2=8; dy2=8; dx3=8; dy4=8;
    porcentaje=1.23;
    break;
    case 10:
    dx2=9; dy2=9; dx3=9; dy4=9;
    porcentaje=1;
    break;    
}
        System.out.println(porcentaje);
        ventana.addKeyListener(new KeyListener() {

                @Override
                public void keyTyped(KeyEvent e) {
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void keyPressed(KeyEvent e) {
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    try{
                    if(e.getKeyCode()==KeyEvent.VK_W){
                        System.out.println("Movimiento hacia arriba");
                        if(dy2>=0&&dy2<=casillas-1){
                        if(mat[dx2][dy2-1]!=c2){
                        cont2=cont2+1;}
                            if(mat[dx2][dy2-1]==c1){
                            cont1-=1;
                            }
                            if(mat[dx2][dy2-1]==c3){
                            cont3-=1;
                            }
                            if(mat[dx2][dy2-1]==c4){
                            cont4-=1;
                            }
                        mat[dx2][dy2]=c2;
                        dy2=dy2-1;
                        mat[dx2][dy2]=p2;
                        }
                        colisionComodines2();
                        if(modo==2){
                        pintarMatriz();
                        }
                        if(modo==4){
                        pintarMatriz4();
                        }
                        if(cont2*porcentaje>100){
                        porcentajep2.setText("Porcentaje jugador2: 100%");
                        }else{
                        porcentajep2.setText("Porcentaje jugador2: "+cont2*porcentaje+"%");
                        }
                    }
                    if(e.getKeyCode()==KeyEvent.VK_S){
                        System.out.println("Movimiento hacia abajo");
                        if(dy2>=0&&dy2<=casillas-1){
                        if(mat[dx2][dy2+1]!=c2){
                        cont2=cont2+1;}
                            if(mat[dx2][dy2+1]==c1){
                            cont1-=1;
                            }
                            if(mat[dx2][dy2+1]==c3){
                            cont3-=1;
                            }
                            if(mat[dx2][dy2+1]==c4){
                            cont4-=1;
                            }
                        mat[dx2][dy2]=c2;
                        dy2=dy2+1;
                        mat[dx2][dy2]=p2;
                        }
                        colisionComodines2();
                        if(modo==2){
                        pintarMatriz();
                        }
                        if(modo==4){
                        pintarMatriz4();
                        }
                        if(cont2*porcentaje>100){
                        porcentajep2.setText("Porcentaje jugador2: 100%");
                        }else{
                        porcentajep2.setText("Porcentaje jugador2: "+cont2*porcentaje+"%");
                        }
                    }
                    if(e.getKeyCode()==KeyEvent.VK_A){
                        System.out.println("Movimiento hacia la izquierda");
                        if(dx2>=0&&dx2<=casillas-1){
                        if(mat[dx2-1][dy2]!=c2){
                        cont2=cont2+1;}
                            if(mat[dx2-1][dy2]==c1){
                            cont1-=1;
                            }
                            if(mat[dx2-1][dy2]==c3){
                            cont3-=1;
                            }
                            if(mat[dx2-1][dy2]==c4){
                            cont4-=1;
                            }
                        mat[dx2][dy2]=c2;
                        dx2=dx2-1;
                        mat[dx2][dy2]=p2;
                        }
                        colisionComodines2();
                        if(modo==2){
                        pintarMatriz();
                        }
                        if(modo==4){
                        pintarMatriz4();
                        }
                        if(cont2*porcentaje>100){
                        porcentajep2.setText("Porcentaje jugador2: 100%");
                        }else{
                        porcentajep2.setText("Porcentaje jugador2: "+cont2*porcentaje+"%");
                        }
                    }
                    if(e.getKeyCode()==KeyEvent.VK_D){
                        System.out.println("Movimiento hacia la derecha");
                        if(dx2>=0&&dx2<=casillas-1){
                        if(mat[dx2+1][dy2]!=c2){
                        cont2=cont2+1;}
                            if(mat[dx2+1][dy2]==c1){
                            cont1-=1;
                            }
                            if(mat[dx2+1][dy2]==c3){
                            cont3-=1;
                            }
                            if(mat[dx2+1][dy2]==c4){
                            cont4-=1;
                            }
                        mat[dx2][dy2]=c2;
                        dx2=dx2+1;
                        mat[dx2][dy2]=p2;
                        }
                        colisionComodines2();
                        if(modo==2){
                        pintarMatriz();
                        }
                        if(modo==4){
                        pintarMatriz4();
                        }
                        if(cont2*porcentaje>100){
                        porcentajep2.setText("Porcentaje jugador2: 100%");
                        }else{
                        porcentajep2.setText("Porcentaje jugador2: "+cont2*porcentaje+"%");
                        }
                    }
                    }catch(java.lang.ArrayIndexOutOfBoundsException a){
                        System.out.println("no se puede jugar fuera de la matriz");
                    }
                }

                @Override
                public void keyReleased(KeyEvent e) {
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            });

    }
    public void moverp3(){
        switch(casillas){
    case 5:
    dx2=4; dy2=4; dx3=4; dy4=4;
    porcentaje=4;
    break;
    case 6:
    dx2=5; dy2=5; dx3=5; dy4=5;
    porcentaje=2.77;
    break;
    case 7:
    dx2=6; dy2=6; dx3=6; dy4=6;
    porcentaje=2.04;
    break;
    case 8:
    dx2=7; dy2=7; dx3=7; dy4=7;
    porcentaje=1.56;
    break;
    case 9:
    dx2=8; dy2=8; dx3=8; dy4=8;
    porcentaje=1.23;
    break;
    case 10:
    dx2=9; dy2=9; dx3=9; dy4=9;
    porcentaje=1;
    break;    
}
            ventana.addKeyListener(new KeyListener() {

                @Override
                public void keyTyped(KeyEvent e) {
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void keyPressed(KeyEvent e) {
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    try{
                    if(e.getKeyCode()==KeyEvent.VK_I){
                        System.out.println("Movimiento hacia arriba");
                        if(dy3>=0&&dy3<=casillas-1){
                        if(mat[dx3][dy3-1]!=c3){
                        cont3=cont3+1;}
                            if(mat[dx3][dy3-1]==c1){
                            cont1-=1;
                            }
                            if(mat[dx3][dy3-1]==c2){
                            cont2-=1;
                            }
                            if(mat[dx3][dy3-1]==c4){
                            cont4-=1;
                            }
                        mat[dx3][dy3]=c3;
                        dy3=dy3-1;
                        mat[dx3][dy3]=p3;
                        }
                        colisionComodines3();
                        pintarMatriz4();
                        if(cont3*porcentaje>100){
                        porcentajep3.setText("Porcentaje jugador3: 100%");
                        }else{
                        porcentajep3.setText("Porcentaje jugador3: "+cont3*porcentaje+"%");
                        }
                    }
                    if(e.getKeyCode()==KeyEvent.VK_K){
                        System.out.println("Movimiento hacia abajo");
                        if(dy3>=0&&dy3<=casillas-1){
                        if(mat[dx3][dy3+1]!=c3){
                        cont3=cont3+1;}
                            if(mat[dx3][dy3+1]==c1){
                            cont1-=1;
                            }
                            if(mat[dx3][dy3+1]==c2){
                            cont2-=1;
                            }
                            if(mat[dx3][dy3+1]==c4){
                            cont4-=1;
                            }
                        mat[dx3][dy3]=c3;
                        dy3=dy3+1;
                        mat[dx3][dy3]=p3;
                        }
                        colisionComodines3();
                        pintarMatriz4();
                        if(cont3*porcentaje>100){
                        porcentajep3.setText("Porcentaje jugador3: 100%");
                        }else{
                        porcentajep3.setText("Porcentaje jugador3: "+cont3*porcentaje+"%");
                        }
                    }
                    if(e.getKeyCode()==KeyEvent.VK_J){
                        System.out.println("Movimiento hacia la izquierda");
                        if(dx3>=0&&dx3<=casillas-1){
                        if(mat[dx3-1][dy3]!=c3){
                        cont3=cont3+1;}
                            if(mat[dx3-1][dy3]==c1){
                            cont1-=1;
                            }
                            if(mat[dx3-1][dy3]==c2){
                            cont2-=1;
                            }
                            if(mat[dx3-1][dy3]==c4){
                            cont4-=1;
                            }
                        mat[dx3][dy3]=c3;
                        dx3=dx3-1;
                        mat[dx3][dy3]=p3;
                        }
                        colisionComodines3();
                        pintarMatriz4();
                        if(cont3*porcentaje>100){
                        porcentajep3.setText("Porcentaje jugador3: 100%");
                        }else{
                        porcentajep3.setText("Porcentaje jugador3: "+cont3*porcentaje+"%");
                        }
                    }
                    if(e.getKeyCode()==KeyEvent.VK_L){
                        System.out.println("Movimiento hacia la derecha");
                        if(dx3>=0&&dx3<=casillas-1){
                        if(mat[dx3+1][dy3]!=c3){
                        cont3=cont3+1;}
                            if(mat[dx3+1][dy3]==c1){
                            cont1-=1;
                            }
                            if(mat[dx3+1][dy3]==c2){
                            cont2-=1;
                            }
                            if(mat[dx3+1][dy3]==c4){
                            cont4-=1;
                            }
                        mat[dx3][dy3]=c3;
                        dx3=dx3+1;
                        mat[dx3][dy3]=p3;
                        }
                        colisionComodines3();
                        pintarMatriz4();
                        if(cont3*porcentaje>100){
                        porcentajep3.setText("Porcentaje jugador3: 100%");
                        }else{
                        porcentajep3.setText("Porcentaje jugador3: "+cont3*porcentaje+"%");
                        }
                    }
                    }
                    catch(java.lang.ArrayIndexOutOfBoundsException a){
                        System.out.println("No se puede jugar fuera de la matriz");
                    }
                }

                @Override
                public void keyReleased(KeyEvent e) {
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            });
    }
    public void moverp4(){
        switch(casillas){
    case 5:
    dx2=4; dy2=4; dx3=4; dy4=4;
    porcentaje=4;
    break;
    case 6:
    dx2=5; dy2=5; dx3=5; dy4=5;
    porcentaje=2.77;
    break;
    case 7:
    dx2=6; dy2=6; dx3=6; dy4=6;
    porcentaje=2.04;
    break;
    case 8:
    dx2=7; dy2=7; dx3=7; dy4=7;
    porcentaje=1.56;
    break;
    case 9:
    dx2=8; dy2=8; dx3=8; dy4=8;
    porcentaje=1.23;
    break;
    case 10:
    dx2=9; dy2=9; dx3=9; dy4=9;
    porcentaje=1;
    break;    
}
            ventana.addKeyListener(new KeyListener() {

                @Override
                public void keyTyped(KeyEvent e) {
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void keyPressed(KeyEvent e) {
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    try{
                    if(e.getKeyCode()==KeyEvent.VK_NUMPAD5){
                        System.out.println("Movimiento hacia arriba");
                        if(dy4>=0&&dy4<=casillas-1){
                        if(mat[dx4][dy4-1]!=c4){
                        cont4=cont4+1;}
                            if(mat[dx4][dy4-1]==c1){
                            cont1-=1;
                            }
                            if(mat[dx4][dy4-1]==c2){
                            cont2-=1;
                            }
                            if(mat[dx4][dy4-1]==c3){
                            cont3-=1;
                            }
                        mat[dx4][dy4]=c4;
                        dy4=dy4-1;
                        mat[dx4][dy4]=p4;
                        }
                        colisionComodines4();
                        pintarMatriz4();
                        if(cont4*porcentaje>100){
                        porcentajep4.setText("Porcentaje jugador4: 100%");
                        }else{
                        porcentajep4.setText("Porcentaje jugador4: "+cont4*porcentaje+"%");
                        }
                    }
                    if(e.getKeyCode()==KeyEvent.VK_NUMPAD2){
                        System.out.println("Movimiento hacia abajo");
                        if(dy4>=0&&dy4<=casillas-1){
                        if(mat[dx4][dy4+1]!=c4){
                        cont4=cont4+1;}
                            if(mat[dx4][dy4+1]==c1){
                            cont1-=1;
                            }
                            if(mat[dx4][dy4+1]==c2){
                            cont2-=1;
                            }
                            if(mat[dx4][dy4+1]==c3){
                            cont3-=1;
                            }
                        mat[dx4][dy4]=c4;
                        dy4=dy4+1;
                        mat[dx4][dy4]=p4;
                        }
                        colisionComodines4();
                        pintarMatriz4();
                        if(cont4*porcentaje>100){
                        porcentajep4.setText("Porcentaje jugador4: 100%");
                        }else{
                        porcentajep4.setText("Porcentaje jugador4: "+cont4*porcentaje+"%");
                        }
                    }
                    if(e.getKeyCode()==KeyEvent.VK_NUMPAD1){
                        System.out.println("Movimiento hacia la izquierda");
                        if(dx4>=0&&dx4<=casillas-1){
                        if(mat[dx4-1][dy4]!=c4){
                        cont4=cont4+1;}
                            if(mat[dx4-1][dy4]==c1){
                            cont1-=1;
                            }
                            if(mat[dx4-1][dy4]==c2){
                            cont2-=1;
                            }
                            if(mat[dx4-1][dy4]==c3){
                            cont3-=1;
                            }
                        mat[dx4][dy4]=c4;
                        dx4=dx4-1;
                        mat[dx4][dy4]=p4;
                        }
                        colisionComodines4();
                        pintarMatriz4();
                        if(cont4*porcentaje>100){
                        porcentajep4.setText("Porcentaje jugador4: 100%");
                        }else{
                        porcentajep4.setText("Porcentaje jugador4: "+cont4*porcentaje+"%");
                        }
                    }
                    if(e.getKeyCode()==KeyEvent.VK_NUMPAD3){
                        System.out.println("Movimiento hacia la derecha");
                        if(dx4>=0&&dx4<=casillas-1){
                        if(mat[dx4+1][dy4]!=c4){
                        cont4=cont4+1;}
                            if(mat[dx4+1][dy4]==c1){
                            cont1-=1;
                            }
                            if(mat[dx4+1][dy4]==c2){
                            cont2-=1;
                            }
                            if(mat[dx4+1][dy4]==c3){
                            cont3-=1;
                            }
                        mat[dx4][dy4]=c4;
                        dx4=dx4+1;
                        mat[dx4][dy4]=p4;
                        }
                        colisionComodines4();
                        pintarMatriz4();
                        if(cont4*porcentaje>100){
                        porcentajep4.setText("Porcentaje jugador4: 100%");
                        }else{
                        porcentajep4.setText("Porcentaje jugador4: "+cont4*porcentaje+"%");
                        }
                    }
                    }
                    catch(java.lang.ArrayIndexOutOfBoundsException a){
                        System.out.println("No se puede jugar fuera de la matriz");
                    }
                }

                @Override
                public void keyReleased(KeyEvent e) {
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            });
    
    }
    
    int comodines; 
    
    public void colisionComodines1(){
        Random rncomodines = new Random();
        int rncomodin= (int)(rncomodines.nextDouble() * 3);
        
        if(comodines==0){
                if(rncomodin==0){
                    if(dx1==rnx&&dy1==rny){
                        System.out.println("el jugador 1 obtuvo el comodin");
                        cont1=cont1+casillas-2;
                        comodines+=1;
                        for (int i = 0; i < casillas; i++) {
                            mat[dx1][i]=c1;
                            }
                        }}
                if(rncomodin==1){
                    if(dx1==rnx&&dy1==rny){
                        System.out.println("el jugador 1 obtuvo el comodin");
                        cont1=cont1+casillas-2;
                        comodines+=1;
                        for (int i = 0; i < casillas; i++) {
                            mat[i][dy1]=c1;
                            }
                        }}
                if(rncomodin==2){
                    if(dx1==rnx&&dy1==rny){
                        System.out.println("el jugador 1 obtuvo el comodin");
                        comodines+=1;
                        if(rnx==0||rny==0||rnx==casillas-1||rny==casillas-1){
                            cont1=cont1+7;
                            mat[0][0]=c1;
                            mat[0][1]=c1;
                            mat[0][2]=c1;
                            mat[1][0]=c1;
                            mat[1][1]=c1;
                            mat[1][2]=c1;
                            mat[2][0]=c1;
                            mat[2][1]=c1;
                            mat[2][2]=c1;
                        }else{
                        cont1=cont1+7;
                            mat[dx1-1][dy1-1]=c1;
                            mat[dx1-1][dy1]=c1;
                            mat[dx1-1][dy1+1]=c1;
                            mat[dx1][dy1-1]=c1;
                            mat[dx1][dy1]=c1;
                            mat[dx1][dy1+1]=c1;
                            mat[dx1+1][dy1-1]=c1;
                            mat[dx1+1][dy1]=c1;
                            mat[dx1+1][dy1+1]=c1;
                            
                        }}}}
    }
    public void colisionComodines2(){
        Random rncomodines = new Random();
        int rncomodin= (int)(rncomodines.nextDouble() * 3);
        if(comodines==0){
                if(rncomodin==0){
                    if(dx2==rnx&&dy2==rny){
                        cont2=cont2+casillas-2;
                        comodines+=1;
                        for (int i = 0; i < casillas; i++) {
                            mat[dx2][i]=c2;
                            }
                        }}
                if(rncomodin==1){
                    if(dx2==rnx&&dy2==rny){
                        cont2=cont2+casillas-2;
                        comodines+=1;
                        for (int i = 0; i < casillas; i++) {
                            mat[i][dy2]=c2;
                            }
                        }}
                if(rncomodin==2){
                    if(dx2==rnx&&dy2==rny){
                        comodines+=1;
                        if(rnx==0||rny==0||rnx==casillas-1||rny==casillas-1){
                            cont2=cont2+7;
                            mat[0][0]=c2;
                            mat[0][1]=c2;
                            mat[0][2]=c2;
                            mat[1][0]=c2;
                            mat[1][1]=c2;
                            mat[1][2]=c2;
                            mat[2][0]=c2;
                            mat[2][1]=c2;
                            mat[2][2]=c2;
                        }else{
                        cont1=cont1+7;
                            mat[dx2-1][dy2-1]=c2;
                            mat[dx2-1][dy2]=c2;
                            mat[dx2-1][dy2+1]=c2;
                            mat[dx2][dy2-1]=c2;
                            mat[dx2][dy2]=c2;
                            mat[dx2][dy2+1]=c2;
                            mat[dx2+1][dy2-1]=c2;
                            mat[dx2+1][dy2]=c2;
                            mat[dx2+1][dy2+1]=c2;
                            
                        }}}}
    }
    public void colisionComodines3(){
        Random rncomodines = new Random();
        int rncomodin= (int)(rncomodines.nextDouble() * 3);
        if(comodines==0){
                if(rncomodin==0){
                    if(dx3==rnx&&dy3==rny){
                        cont3=cont3+casillas-2;
                        comodines+=1;
                        for (int i = 0; i < casillas; i++) {
                            mat[dx3][i]=c3;
                            }
                        }}
                if(rncomodin==1){
                    if(dx3==rnx&&dy3==rny){
                        cont3=cont3+casillas-2;
                        comodines+=1;
                        for (int i = 0; i < casillas; i++) {
                            mat[i][dy3]=c3;
                            }
                        }}
                if(rncomodin==2){
                    if(dx3==rnx&&dy3==rny){
                        comodines+=1;
                        if(rnx==0||rny==0||rnx==casillas-1||rny==casillas-1){
                            cont3=cont3+7;
                            mat[0][0]=c3;
                            mat[0][1]=c3;
                            mat[0][2]=c3;
                            mat[1][0]=c3;
                            mat[1][1]=c3;
                            mat[1][2]=c3;
                            mat[2][0]=c3;
                            mat[2][1]=c3;
                            mat[2][2]=c3;
                        }else{
                        cont3=cont3+7;
                            mat[dx3-1][dy3-1]=c3;
                            mat[dx3-1][dy3]=c3;
                            mat[dx3-1][dy3+1]=c3;
                            mat[dx3][dy3-1]=c3;
                            mat[dx3][dy3]=c3;
                            mat[dx3][dy3+1]=c3;
                            mat[dx3+1][dy3-1]=c3;
                            mat[dx3+1][dy3]=c3;
                            mat[dx3+1][dy3+1]=c3;
                            
                        }}}}
    }
    public void colisionComodines4(){
        Random rncomodines = new Random();
        int rncomodin= (int)(rncomodines.nextDouble() * 3);
        if(comodines==0){
                if(rncomodin==0){
                    if(dx4==rnx&&dy4==rny){
                        cont4=cont4+casillas-2;
                        comodines+=1;
                        for (int i = 0; i < casillas; i++) {
                            mat[dx4][i]=c4;
                            }
                        }}
                if(rncomodin==1){
                    if(dx4==rnx&&dy4==rny){
                        cont4=cont4+casillas-2;
                        comodines+=1;
                        for (int i = 0; i < casillas; i++) {
                            mat[i][dy4]=c4;
                            }
                        }}
                if(rncomodin==2){
                    if(dx4==rnx&&dy4==rny){
                        comodines+=1;
                        if(rnx==0||rny==0||rnx==casillas-1||rny==casillas-1){
                            cont2=cont2+7;
                            mat[0][0]=c4;
                            mat[0][1]=c4;
                            mat[0][2]=c4;
                            mat[1][0]=c4;
                            mat[1][1]=c4;
                            mat[1][2]=c4;
                            mat[2][0]=c4;
                            mat[2][1]=c4;
                            mat[2][2]=c4;
                        }else{
                        cont4=cont4+7;
                            mat[dx4-1][dy4-1]=c4;
                            mat[dx4-1][dy4]=c4;
                            mat[dx4-1][dy4+1]=c4;
                            mat[dx4][dy4-1]=c4;
                            mat[dx4][dy4]=c4;
                            mat[dx4][dy4+1]=c4;
                            mat[dx4+1][dy4-1]=c4;
                            mat[dx4+1][dy4]=c4;
                            mat[dx4+1][dy4+1]=c4;
                            
                        }}}}
    }
    
    //colores
    int casillas1, casillas2, casillas3, casillas4;
    public void Finalizar(){
        double completado=(cont1+cont2+cont3+cont4)*porcentaje;
               if(completado>=98.5){
                   if(cont1>cont2&&cont1>cont3&&cont1>cont4){
                       System.out.println(casillas1);
               JOptionPane.showMessageDialog(panelJuego2, "Felicitaciones, el jugador numero 1 a ganado");
                   }
                   if(cont2>cont1&&cont2>cont3&&cont2>cont4){
                       System.out.println(casillas2);
               JOptionPane.showMessageDialog(panelJuego2, "Felicitaciones, el jugador numero 2 a ganado");
                   }
                   if(cont3>cont2&&cont3>cont1&&cont3>cont4){
                       System.out.println(casillas3);
               JOptionPane.showMessageDialog(panelJuego2, "Felicitaciones, el jugador numero 3 a ganado");
                   }
                   if(cont4>cont2&&cont4>cont3&&cont4>cont1){
                       System.out.println(casillas4);
               JOptionPane.showMessageDialog(panelJuego2, "Felicitaciones, el jugador numero 4 a ganado");
                   }
               }
    }    
}
