/** class of level, where game take some parameters of objects
 * @author ismukmak
 * @author utemiadi
 */

package GameState;

import Entity.Enemies.*;
import Entity.*;
import Main.GamePanel;
import Main.SetLogger;
import TileMap.*;
import java.awt.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.awt.event.KeyEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class LevelState extends GameState {

    private TileMap tileMap;
    private Background bg;
    private Player player;
    private HUD hud;
    private SetLogger logger = new SetLogger();
    private ArrayList<Enemy> enemies;
    private ArrayList<ThingD> thingsD;
    private ArrayList<ThingG> thingsG;
    private ArrayList<Explosion> explosions;
    private ArrayList<BigEnemy> bigEnemies;
    private String levelFilePath = "src/main/coordinates/Level1_Enemy";

    private int deadDiamonds = 0;
    private int deadSluggers = 0;
    private int deadGolds = 0;
    private int space = 0;
    private int x, y;
    private int health;
    private int fire;

    /**
     * Assigning a local variable gsm to the instance variable gsm
     * @param gsm contains application states
     */
    LevelState(GameStateManager gsm) {
        this.gsm = gsm;
        init();
    }

    /**
     * declaration methods from files 
     */
    public void init() {
        tileMap = new TileMap();
        tileMap.loadTiles("/Tilesets/grasstileset.png");
        String path = null;
        try {
            path = Files.readAllLines(Paths.get(levelFilePath)).get(5);
        } catch (IOException e) {
            e.printStackTrace();
        }
        tileMap.loadMap(path);
        tileMap.setPosition(0, 0);

        bg = new Background("/Backgrounds/grassbg1.png");
        player = new Player(tileMap);
        try{
            Scanner sc = new Scanner(new File("src/main/Save/save.txt"));
            while (sc.hasNext()) {
                x = sc.nextInt();
                y = sc.nextInt();
                deadDiamonds = sc.nextInt();
                deadGolds = sc.nextInt();
                deadSluggers = sc.nextInt();
                health = sc.nextInt();
                space = sc.nextInt();
                fire = sc.nextInt();
            }
            sc.close();
        }catch(FileNotFoundException e) {
            logger.writeLogger(LevelState.class.getName() + "init.fileread", e);
        }

        player.setPosition(x, y);
        player.setHealth(health);
        player.setFire(fire);
        populateEnemies();
        populateDiamonds();
        populateGolds();
        populateHulk();
        explosions = new ArrayList<Explosion>();
        hud = new HUD(player);
    }

    /*
     creating enemies 
     */
    private void populateEnemies() {
        enemies = new ArrayList<Enemy>();
        Wolf s;
        String r = null;
        try {
            r = Files.readAllLines(Paths.get(levelFilePath)).get(0);
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Point> points = new ArrayList<Point>();
        String[] arr = r.split("\\);\\s*");
        for (String anArr : arr){
            int x = Integer.parseInt(anArr.substring(1,anArr.indexOf(" ")));
            int y = Integer.parseInt(anArr.substring(anArr.indexOf(" ") + 1, anArr.length()));
            Point p = new Point(x,y);
            points.add(p);
        }
        for(int i = 0; i < points.size() - this.deadSluggers; i++) {
            s = new Wolf(tileMap);
            s.setPosition(points.get(i).x, points.get(i).y);
            enemies.add(s);
        }
    }

    /*
     creating golds 
     */
    private void populateGolds()  {
        thingsG = new ArrayList<ThingG>();
        Gold gold;

        String r = null;
        try {
            r = Files.readAllLines(Paths.get(levelFilePath)).get(1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Point> points = new ArrayList<Point>();
        String[] arr = r.split("\\);\\s*");
        for (String anArr : arr){
            int x = Integer.parseInt(anArr.substring(1,anArr.indexOf(" ")));
            int y = Integer.parseInt(anArr.substring(anArr.indexOf(" ") + 1, anArr.length()));
            Point p = new Point(x,y);
            points.add(p);
        }
        for(int i = 0; i < points.size() - this.deadGolds; i++) {
            gold = new Gold(tileMap);
            gold.setPosition(points.get(i).x, points.get(i).y);
            thingsG.add(gold);
        }
    }

    /*
     creating diamonds
     */
    private void populateDiamonds()  {
        thingsD = new ArrayList<>();
        Diamond diamond;
        String r = null;
        try {
            r = Files.readAllLines(Paths.get(levelFilePath)).get(2);
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Point> points = new ArrayList<Point>();
        assert r != null;
        String[] arr = r.split("\\);\\s*");
        for (String anArr : arr){
            int x = Integer.parseInt(anArr.substring(1,anArr.indexOf(" ")));
            int y = Integer.parseInt(anArr.substring(anArr.indexOf(" ") + 1, anArr.length()));
            Point p = new Point(x,y);
            points.add(p);
        }
        for(int i = 0; i < points.size() - this.deadDiamonds; i++) {
            diamond = new Diamond(tileMap);
            diamond.setPosition(points.get(i).x, points.get(i).y);
            thingsD.add(diamond);
        }
    }

    /*
     creating hulk 
     */
    private void populateHulk()  {
        bigEnemies = new ArrayList<BigEnemy>();
        Hulk hulk;
        String r = null;
        try {
            r = Files.readAllLines(Paths.get("src/main/coordinates/Level1_Enemy")).get(3);
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Point> points = new ArrayList<Point>();
        String[] arr = r.split("\\);\\s*");
        for (String anArr : arr){
            int x = Integer.parseInt(anArr.substring(1,anArr.indexOf(" ")));
            int y = Integer.parseInt(anArr.substring(anArr.indexOf(" ") + 1, anArr.length()));
            Point p = new Point(x,y);
            points.add(p);
        }
        for (Point point : points) {
            hulk = new Hulk(tileMap);
            hulk.setPosition(point.x, point.y);
            bigEnemies.add(hulk);
        }
    }

    public void update() {
        //update player
        player.update();
        tileMap.setPosition(GamePanel.WIDTH / 2 - player.getx(), GamePanel.HEIGHT / 2 - player.gety());

        //atack enemies
        player.checkAtackEnemies(enemies);
        player.checkAtackDiamonds(thingsD);
        player.checkAtackGolds(thingsG);
        player.checkAtackHulk(bigEnemies);

        //update all enemies
        for(int i = 0; i < enemies.size(); i++) {
            Enemy e = enemies.get(i);
            e.update();
            if(e.isDead()) {
                enemies.remove(i);
                i--;
                deadSluggers++;
                explosions.add(new Explosion(e.getx(), e.gety()));
            }
        }

        //update all diamonds
        for(int i = 0; i < thingsD.size(); i++) {
            ThingD thing = thingsD.get(i);
            //thing.update();
            if(thing.isDead()) {
                thingsD.remove(i);
                i--;
                deadDiamonds++;
            }
        }

        //update all golds
        for(int i = 0; i < thingsG.size(); i++) {
            ThingG thing = thingsG.get(i);
            thing.update();
            if(thing.isDead()) {
                thingsG.remove(i);
                i--;
                deadGolds++;
            }
        }

        //update big dragon
        for(int i = 0; i < bigEnemies.size(); i++) {
            BigEnemy bigEnemy = bigEnemies.get(i);
            bigEnemy.update();
        }

        //update explosions
        for(int i = 0; i < explosions.size(); i++) {
            explosions.get(i).update();

            if(explosions.get(i).shouldRemove()) {
                explosions.remove(i);
                i--;
            }
        }
    }

    public void draw(Graphics2D g) throws IOException {

        //draw bg
        bg.draw(g);
        // draw tilemap
        tileMap.draw(g);

        //draw player
        player.draw(g);

        //draw diamonds
        for (int i = 0; i < thingsD.size(); i++) {
            thingsD.get(i).draw(g);
        }

        //draw golds
        for (int i = 0; i < thingsG.size(); i++) {
            thingsG.get(i).draw(g);
        }

        //enemies
        for (int i = 0; i < enemies.size(); i++) {
            enemies.get(i).draw(g);
        }

        //draw big dragon
        for (int i = 0; i < bigEnemies.size(); i++) {
            bigEnemies.get(i).draw(g);
        }

        //draw explosions
        for (int i = 0; i < explosions.size(); i++) {
            explosions.get(i).setMapPosition(
                    (int) tileMap.getx(), (int) tileMap.gety()
            );
            explosions.get(i).draw(g);
        }

        //draw hud
        hud.draw(g);
        //draw hud of diamonds and golds
        g.drawString("x" + this.deadDiamonds, 35, 67);
        g.drawString("x" + this.deadGolds, 35, 88);

        if (player.getHealth() == 0 || player.gety() >= 225) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            gsm.setState(GameStateManager.GAMEOVERSTATE);
            player.setDead();
            player.setPosition(100, 100);
            player.setHealth(3);
        }

        if (player.getx() >= 3050) {
            g.setColor(Color.white);
            g.fillRect(25, 105, 259, 43);
            g.setColor(Color.black);
            g.setFont(new Font("Times New Roman", Font.PLAIN, 15));
            g.drawString("   Hulk: I want 9 golds and 3 diamonds.", 25, 120);
            g.setColor(Color.green);
            g.drawString("to continue press SPACE", 80, 140);

            if (this.space == 1) {
                g.setColor(Color.white);
                g.fillRect(25, 105, 259, 43);
                g.setColor(Color.black);
                g.drawString("   Hulk: If you don't have, you will die.", 30, 120);
                g.setColor(Color.green);
                g.drawString("to continue press SPACE", 80, 140);
            }
            if (this.space == 2) {
                g.setColor(Color.white);
                g.fillRect(25, 105, 259, 43);
                g.setColor(Color.black);
                if (this.deadDiamonds >= 3 && this.deadGolds >= 9)
                    g.drawString("Me: I have", 120, 120);
                else
                    g.drawString("Me: I don't have that much", 75, 120);
                g.setColor(Color.green);
                g.drawString("to continue press SPACE", 80, 140);
            }
            if (this.space == 3) {
                g.setColor(Color.white);
                g.fillRect(25, 105, 259, 43);
                g.setColor(Color.black);
                if (this.deadDiamonds >= 3 && this.deadGolds >= 9) {
                    g.drawString("    Hulk: Thanks! You win!", 65, 120);
                } else
                    g.drawString("    Hulk: Sorry, but ... bye", 65, 120);
                g.setColor(Color.green);
                g.drawString("to continue press SPACE", 80, 140);
            }
            if (this.space == 4) {
                try {
                    Thread.sleep(700);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (this.deadDiamonds >= 3 && this.deadGolds >= 9) {
                    this.deadDiamonds = 0;
                    this.deadGolds = 0;
                    this.deadSluggers = 0;
                    this.space = 0;
                    gsm.setState(GameStateManager.FINISHSTATE);
                } else {
                    gsm.setState(GameStateManager.GAMEOVERSTATE);
                    player.setDead();
                }
            }
        }
    }

    /**
     * Called by the system in case of pressing any key on the keyboard
     * @param k generated when typing from the keyboard
     * throws IOException if the key can not be pressed
     */
    public void keyPressed(int k) throws IOException {
        if (k == KeyEvent.VK_ESCAPE) {
            gsm.setState(GameStateManager.PAUSESTATE);
            System.out.println(player.getx() + " " + player.gety());
            BufferedWriter writer;
            writer = new BufferedWriter(new FileWriter("src/main/Save/save.txt"));
            writer.write(player.getx() + "\n" + player.gety() + "\n" + deadDiamonds + "\n" + deadGolds + "\n" + deadSluggers + "\n" + player.getHealth() + "\n" + this.space + "\n" + player.getFire());
            writer.close();
        }
        else {
            if (k == KeyEvent.VK_SPACE)
                space += 1;
            if (k == KeyEvent.VK_LEFT)
                player.setLeft(true);
            if (k == KeyEvent.VK_RIGHT)
                player.setRight(true);
            if (k == KeyEvent.VK_UP)
                player.setUp(true);
            if (k == KeyEvent.VK_DOWN)
                player.setDown(true);
            if (k == KeyEvent.VK_W)
                player.setJumping(true);
            if (k == KeyEvent.VK_E)
                player.setGliding(true);
            if (k == KeyEvent.VK_R)
                player.setScratching();
            if (k == KeyEvent.VK_F)
                player.setFiring();
        }
    }

    /**
     * Called when you release any key on the keyboard
     * @param k generated when typing from the keyboard
     * throws IOException if the key can not be pressed
     */
    public void keyReleased(int k) {
        if(k == KeyEvent.VK_LEFT)
            player.setLeft(false);
        if(k == KeyEvent.VK_RIGHT)
            player.setRight(false);
        if(k == KeyEvent.VK_UP)
            player.setUp(false);
        if(k == KeyEvent.VK_DOWN)
            player.setDown(false);
        if(k == KeyEvent.VK_W)
            player.setJumping(false);
        if(k == KeyEvent.VK_E)
            player.setGliding(false);
    }

}
