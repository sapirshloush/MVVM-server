package searchLib.SokobanSearcher;



import searchLib.Searchable;
import searchLib.State;
import java.util.*;

import model.data.Level;
import model.data.Position;
import model.policy.MySokobanPolicy;


public class SokobanSearchable implements Searchable<Position>
{
    private Level level, simulateLevel;
    private Position startPos;
    private Position goalPos;
    private String descProblem;

    public SokobanSearchable(Level level, Position start, Position end, String descProblem)
    {
        this.level = level;
        this.simulateLevel = new Level(level);
        this.startPos = start;
        this.goalPos = end;
        this.descProblem = descProblem;
    }

    @Override
    public State<Position> getInitialState()
    {
        return new State<>(this.startPos);
    }

    @Override
    public State<Position> getGoalState()
    {
        return new State<>(this.goalPos);
    }

    @Override
    public List<State<Position>> getAllStates()
    {
        return null;
    }

    @Override
    public List<State<Position>> getAllPossibleStates(State<Position> state)
    {
        List<State<Position>> possibleStates=new ArrayList<>();
        Position down=null , up=null , left=null , right=null, problemPos=null;
        State<Position> newState = null;



        if(descProblem.equals("sokoban"))
        {
            problemPos = state.getState();

            down = new Position(problemPos.getX() + 1, problemPos.getY());
            up = new Position(problemPos.getX() - 1, problemPos.getY());
            left = new Position(problemPos.getX(), problemPos.getY() - 1);
            right = new Position(problemPos.getX(), problemPos.getY() + 1);

            if (MySokobanPolicy.isValidMove("up", level))
            {
                newState = new State<>(up);
                newState.setCost(state.getCost() + 1);
                possibleStates.add(newState);//createState(problemPos, up, level,"sokoban"));
            }
            if (MySokobanPolicy.isValidMove("down", level))
            {
                newState = new State<>(down);
                newState.setCost(state.getCost() + 1);
                possibleStates.add(newState);//createState(problemPos, down, board,"sokoban"));
            }
            if (MySokobanPolicy.isValidMove("left", level))
            {
                newState = new State<>(left);
                newState.setCost(state.getCost() + 1);
                possibleStates.add(newState);//createState(problemPos, left, board,"sokoban"));
            }
            if (MySokobanPolicy.isValidMove("right", level))
            {
                newState = new State<>(right);
                newState.setCost(state.getCost() + 1);
                possibleStates.add(newState);//createState(problemPos, right, board,"sokoban"));
            }

            return possibleStates;
        }

        else
        {
            problemPos = state.getState();
            down = new Position(problemPos.getX() + 1, problemPos.getY());
            up = new Position(problemPos.getX() - 1, problemPos.getY());
            left = new Position(problemPos.getX(), problemPos.getY() - 1);
            right = new Position(problemPos.getX(), problemPos.getY() + 1);

            if (MySokobanPolicy.isValidBoxMove("up", level, problemPos))
            {
                newState = new State<>(up);
                newState.setCost(state.getCost() + 1);
                possibleStates.add(newState);//createState(pos, up, board, "box"));
            }

            if (MySokobanPolicy.isValidBoxMove("down", level, problemPos))
            {
                newState = new State<>(down);
                newState.setCost(state.getCost() + 1);
                possibleStates.add(new State<>(down));//createState(pos, down, board, "box"));
            }

            if (MySokobanPolicy.isValidBoxMove("left", level, problemPos))
            {
                newState = new State<>(left);
                newState.setCost(state.getCost() + 1);
                possibleStates.add(new State<>(left));//createState(pos, left, board, "box"));
            }

            if (MySokobanPolicy.isValidBoxMove("right", level, problemPos))
            {
                newState = new State<>(right);
                newState.setCost(state.getCost() + 1);
                possibleStates.add(new State<>(right));//createState(pos, right, board, "box"));
            }

            return possibleStates;
        }

    }


    /*private State<Level> createState(Position oldPos, Position newPos, Level level,String description)
    {
        ArrayList<ArrayList<ItemInWarehouse>> board=new ArrayList<>(level.getBoard().size());
        ArrayList<ItemInWarehouse> rowBoard;

        //boolean flag=false;


        for(int i=0;i<level.getBoard().size();i++)
        {
            rowBoard = new ArrayList<>(level.getBoard().get(i).size());
            ItemInWarehouse[] iiw = new ItemInWarehouse[level.getBoard().get(i).size()];
            for(int j=0;j<level.getBoard().get(i).size();j++)
            {

                if((i == newPos.getX()) && (j == newPos.getY()))
                {
                    if (description.equals("sokoban"))
                        iiw[j] = new Player(newPos);
                    else
                        iiw[j]= new Box(newPos);

                    continue;
                }

                if((i == oldPos.getX()) && (j == oldPos.getY()))
                    continue;

                if(level.getBoard().get(i).get(j) instanceof Wall)
                    iiw[j] = new Wall(new Position(i,j));

                if (level.getBoard().get(i).get(j) instanceof Box)
                    iiw[j] = new Box(new Position(i, j));


                if (level.getBoard().get(i).get(j) instanceof AnchorPoint)
                {
                    AnchorPoint ap = (AnchorPoint) level.getBoard().get(i).get(j);
                    iiw[j] = new AnchorPoint(ap);
                }

            }

            Collections.addAll(rowBoard,iiw);
            board.add(i,rowBoard);


        }*/




        /*for(int i = 0 ; i<level.getBoard().size();i++)
        {
            board.add( new ArrayList<>());

            for(int j=0;j<level.getBoard().get(i).size();j++)
            {
                if((i == newPos.getX()) && (j == newPos.getY()))
                {
                    if (description.equals("sokoban"))
                        board.get(i).add(new Player(newPos));
                    else
                        board.get(i).add( new Box(newPos));
                }
                if((i==oldPos.getX()) && (j==oldPos.getY()))
                {
                    board.get(i).add(new Box(null));
                    //board.get(i).set(j,null);
                }

                if(level.getBoard().get(i).get(j) instanceof Wall)
                    board.get(i).add( new Wall(new Position(i,j)));

                if(level.getBoard().get(i).get(j) instanceof Box)
                    board.get(i).add( new Box(new Position(i,j)));

                if(level.getBoard().get(i).get(j) instanceof AnchorPoint)
                {
                    AnchorPoint ap = (AnchorPoint) level.getBoard().get(i).get(j);
                    board.get(i).add( new AnchorPoint(ap));
                }
            }
        }

        Level newLevel = new Level();
        newLevel.setBoard(board);
        return new State<>(newLevel);
    }
    */
}
