package searchLib.SokobanSearcher;



import searchLib.Action;
import searchLib.BFS;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import model.data.Level;
import model.data.MyTextLevelLoader;
import model.data.Position;

public class Main
{

    public static void main(String[] args)
    {

        MyTextLevelLoader leveloader = new MyTextLevelLoader();
        Level level=null;

        try {
            level = leveloader.loadLevel(new FileInputStream("./level2.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        SokobanSearchable sokoSearch = new SokobanSearchable(level, new Position(1, 2), new Position(1, 7), "box");
        BFS<Position> bfs = new BFS<>();

        ArrayList<Action<Position>> path = bfs.search(sokoSearch);
        System.out.println(path == null);
        if(path != null)
        {
            for(int i=path.size()-1; i>=0;i--)
            {
                System.out.println(path.get(i));
            }
        }

    }

}
