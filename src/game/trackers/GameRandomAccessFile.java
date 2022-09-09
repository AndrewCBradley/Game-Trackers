/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.trackers;

/**
 *
 * @author andre
 */
import static java.awt.PageAttributes.MediaType.C;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.sql.Date;

public class GameRandomAccessFile {
    private static final int RECORD_SIZE = 81;//Desired size record
    private static final int GAME_NAME_SIZE = 50;//Desired length of string
    private static String filePath ="C:\\FileHandling\\gameData.txt";
    
    public static void main(String[] args) throws IOException{
        File myFile = new File(filePath);
        fileInfo(myFile);
    }
    public static boolean createFileIfNotExist(){
        try{
            File myFile = new File(filePath);
            if (myFile.createNewFile()) {
                System.out.println("File created: "+myFile.getName());
                return true;
            }else{
                System.out.println("File already exists");
                return true;
            }
        } catch(IOException e){
            System.out.println(e.getMessage()+"An error has occured");
            return false;
        }
    }
    public static void fileInfo(File myFile){
        if (createFileIfNotExist()) {
            System.out.println("File name: "+ myFile.getName());
            System.out.println("Absolute Path: "+myFile.getAbsolutePath());
            //System.out.println("Writeable:" + myFile.canWrite());
            //System.out.println("Readable:" + myFile.canRead());
            System.out.println("File size in bytes: "+myFile.length());
        }else{
            System.out.println("An error has occured");
        }
    }

    public static int writeRecord(Game game) throws IOException{
        File myFile = new File(filePath);
        int id;
        id = (int) ((myFile.length()/RECORD_SIZE));
        if (createFileIfNotExist()) {
            try{
               
                RandomAccessFile raf= new RandomAccessFile(filePath, "rw");
                raf.seek(myFile.length());//Add data to end of file
                raf.writeInt(id);
                raf.writeBoolean(false);//If true then it is "deleted"
                raf.writeLong(game.getDate().getTime());
                raf.writeUTF(extendString(game.getGameName()));
                raf.writeInt(game.getRounds());
                raf.writeInt(game.getFrags());
                raf.writeInt(game.getDeaths());
                raf.writeInt(game.getAssists());
                raf.close();
                System.out.println("Data Added RAF");
                //fileInfo(myFile);
                
            }catch(IOException e){
                
            }
        }
        return id;
    }
    public static String extendString(String gameName){
        String temp = gameName;//Stores gameName
        for (int i = GAME_NAME_SIZE; i > temp.length(); i--) {//Make it so each of the strings stored in the raf are the same length
            gameName +=" ";
        }
        return gameName;//Makes it so seeking is possible.
    }
    public static LinkedList readRecords() throws IOException, Exception{
        createFileIfNotExist();//Error handling if there is no file.
        File myFile = new File(filePath);
        RandomAccessFile raf= new RandomAccessFile(filePath, "rw");
        LinkedList gameList = new LinkedList();
        for (int i = 0; i < (myFile.length()/RECORD_SIZE); i++) {
            int id = raf.readInt();
            boolean isDeleted =raf.readBoolean();
            Date date = new Date(raf.readLong());
            //System.out.println("readRecords Date: " + date);
            String gameName =raf.readUTF().trim();
            int rounds = raf.readInt();
            int frags = raf.readInt();
            int deaths = raf.readInt();
            int assists = raf.readInt();
            if (!isDeleted) {
                Game game = new GameRAF(date, gameName, rounds, frags, deaths, assists);
                ((GameRAF)game).setId(id);//Polymorphism
                gameList.add(game);
            }
        } 
        raf.close();
        return gameList;//Returns all records that were not deleted
    }
    public static boolean deleteRecord(int id) throws FileNotFoundException, IOException{
        createFileIfNotExist();//Error handling if there is no file.
        File myFile = new File(filePath);
        if (id>=0&&id<=myFile.length()/RECORD_SIZE) {//Each record is currently 81 bytes
            RandomAccessFile raf= new RandomAccessFile(filePath, "rw");
            raf.seek((RECORD_SIZE*id));
            if (id == raf.readInt()) {
                raf.writeBoolean(true);//"deletes" the record
            }else{
                System.out.println("Error on seeking");
                return false;
            }
        }
        return false;
        
    }
    public static LinkedList searchRecordByDate(Date inputDate) throws FileNotFoundException, IOException, Exception{
        createFileIfNotExist();
        File myFile = new File(filePath);
        RandomAccessFile raf= new RandomAccessFile(filePath, "rw");
        LinkedList gameList = new LinkedList();
        for (int i = 0; i < (myFile.length()/RECORD_SIZE); i++) {
            int id = raf.readInt();
            boolean isDeleted =raf.readBoolean();
            long longDate = raf.readLong();
            Date date = new Date(longDate);
            System.out.println("Date: " + date);
            String gameName =raf.readUTF().trim();//Gets rid of the extra spaces added in extendString()
            int rounds = raf.readInt();
            int frags = raf.readInt();
            int deaths = raf.readInt();
            int assists = raf.readInt();
            if (!isDeleted&&inputDate.getTime()==longDate) {
                Game game = new GameRAF(date, gameName, rounds, frags, deaths, assists);
                ((GameRAF)game).setId(id);//Polymorphism. Related as id is added
                gameList.add(game);
            }
        } 
        raf.close();//Closes the file
        return gameList;
    }
    public static LinkedList searchRecordByGame(String inputGameName) throws FileNotFoundException, IOException, Exception{//Used to calculate averages
        createFileIfNotExist();
        File myFile = new File(filePath);
        RandomAccessFile raf= new RandomAccessFile(filePath, "rw");
        LinkedList gameList = new LinkedList();
        for (int i = 0; i < (myFile.length()/RECORD_SIZE); i++) {
            int id = raf.readInt();
            boolean isDeleted =raf.readBoolean();//If it is true then file is "deleted"
            long longDate = raf.readLong();
            Date date = new Date(longDate);
            //System.out.println("Date: " + date);
            String gameName =raf.readUTF().trim();//Gets rid of the extra spaces added in extendString()
            int rounds = raf.readInt();
            int frags = raf.readInt();
            int deaths = raf.readInt();
            int assists = raf.readInt();
            if (inputGameName.equals("All Games")) {//Adds all games if All Games is selected
                Game game = new GameRAF(date, gameName, rounds, frags, deaths, assists);
                ((GameRAF)game).setId(id);//Polymorphism
                gameList.add(game);
            }else if (!isDeleted&& gameName.equals(inputGameName)) {//Adds only games with the specific name to list.
                Game game = new GameRAF(date, gameName, rounds, frags, deaths, assists);
                ((GameRAF)game).setId(id);//Polymorphism
                gameList.add(game);
            }
        } 
        raf.close();
        return gameList;
    }

    
}
