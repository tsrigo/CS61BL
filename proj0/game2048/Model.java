package game2048;

import java.util.Formatter;
import java.util.Observable;


/** The state of a game of 2048.
 *  @author : Tsrigo
 */
public class Model extends Observable {
    /** Current contents of the board. */
    private Board _board;
    /** Current score. */
    private int _score;
    /** Maximum score so far.  Updated when game ends. */
    private int _maxScore;
    /** True iff game is ended. */
    private boolean _gameOver = false;

    /* Coordinate System: column C, row R of the board (where row 0,
     * column 0 is the lower-left corner of the board) will correspond
     * to board.tile(c, r).  Be careful! It works like (x, y) coordinates.
     */

    /** Largest piece value. */
    public static final int MAX_PIECE = 2048;

    /** A new 2048 game on a board of size SIZE with no pieces
     *  and score 0. */
    public Model(int size) {
        // TODO: Fill in this constructor.
        this._board = new Board(size);
        this._score = 0;
        this._maxScore = 0;
    }

    /** A new 2048 game where RAWVALUES contain the values of the tiles
     * (0 if null). VALUES is indexed by (row, col) with (0, 0) corresponding
     * to the bottom-left corner. Used for testing purposes. */
    public Model(int[][] rawValues, int score, int maxScore, boolean gameOver) {
        // TODO: Fill in this constructor.
        this._maxScore = maxScore;
        this._score = score;
        this._gameOver = gameOver;

        this._board = new Board(rawValues, score);
    }

    /** Return the current Tile at (COL, ROW), where 0 <= ROW < size(),
     *  0 <= COL < size(). Returns null if there is no tile there.
     *  Used for testing. Should be deprecated and removed.
     */
    public Tile tile(int col, int row) {
        return _board.tile(col, row);
    }

    /** Return the number of squares on one side of the board.
     *  Used for testing. Should be deprecated and removed. */
    public int size() {
        return _board.size();
    }

    /** Return true iff the game is over (there are no moves, or
     *  there is a tile with value 2048 on the board). */
    public boolean gameOver() {
        checkGameOver();
        if (_gameOver) {
            _maxScore = Math.max(_score, _maxScore);
        }
        return _gameOver;
    }

    /** Return the current score. */
    public int score() {
        return _score;
    }

    /** Return the current maximum game score (updated at end of game). */
    public int maxScore() {
        return _maxScore;
    }

    /** Clear the board to empty and reset the score. */
    public void clear() {
        _score = 0;
        _gameOver = false;
        _board.clear();
        setChanged();
    }

    /** Add TILE to the board. There must be no Tile currently at the
     *  same position. */
    public void addTile(Tile tile) {
        _board.addTile(tile);
        checkGameOver();
        setChanged();
    }

    /** Tilt the board toward SIDE. Return true iff this changes the board.
     *
     * 1. If two Tile objects are adjacent in the direction of motion and have
     *    the same value, they are merged into one Tile of twice the original
     *    value and that new value is added to the score instance variable
     * 2. A tile that is the result of a merge will not merge again on that
     *    tilt. So each move, every tile will only ever be part of at most one
     *    merge (perhaps zero).
     * 3. When three adjacent tiles in the direction of motion have the same
     *    value, then the leading two tiles in the direction of motion merge,
     *    and the trailing tile does not.
     */

    public void tilt_each(){}
    public boolean tilt(Side side) {
        boolean changed;
        changed = false;

        // TODO: Fill in this function.
        Board b = _board;
        b.setViewingPerspective(side);
        for (int col = 0; col < b.size(); col ++ ) {            // deal column by column
            for (int ori = b.size() - 1; ori >= 0; ori -- ) {   // fix a target called t_ori, where the coordinate is (col, ori)
                for (int now = ori - 1; now >= 0; now -- ) {    // t_now is the tile that be moved.
                    Tile t_ori = b.tile(col, ori), t_now = b.tile(col, now);
                    if (t_now == null) continue;                // add this judgement to avoid "null" bug
                    // important idea ! We move the t_now iff the target is null or its value equals now's.
                    if (t_ori == null || t_now.value() == t_ori.value()){
                        changed = true;
                        boolean flag = b.move(col, ori, t_now);

                        if (!flag) ori ++ ; // this tile still have chance to be merged, so we should use `ori ++` to offset the `ori -- `
                        else _score += b.tile(col, ori).value(); // Apparently, we should modify the _score iff the tilt is a merge.

                        break;
                    }
                }
            }
        }

        b.setViewingPerspective(Side.NORTH);
//      if (b != _board) changed = true; // wrong method

        if (changed) {
            setChanged();
        }
        return changed;
    }

    /** Checks if the game is over and sets the gameOver variable
     *  appropriately.
     */
    private void checkGameOver() {
        _gameOver = checkGameOver(_board);
    }

    /** Determine whether game is over. */
    private static boolean checkGameOver(Board b) {
        return maxTileExists(b) || !atLeastOneMoveExists(b);
    }

    /** Returns true if at least one space on the Board is empty.
     *  Empty spaces are stored as null.
     */
    public static boolean emptySpaceExists(Board b) {
        // TODO: Fill in this function.
        int size = b.size();
        for (int col = 0; col < size; col ++ ){
            for (int row = 0; row < size; row ++ ){
                Tile t = b.tile(col, row);
                if(t == null){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Returns true if any tile is equal to the maximum valid value.
     * Maximum valid value is given by MAX_PIECE. Note that
     * given a Tile object t, we get its value with t.value().
     */
    public static boolean maxTileExists(Board b) {
        // TODO: Fill in this function.
        int size = b.size();
        for (int col = 0; col < size; col ++ ){
            for (int row = 0; row < size; row ++ ){
                Tile t = b.tile(col, row);
                if(t != null && t.value() == MAX_PIECE){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Returns true if there are any valid moves on the board.
     * There are two ways that there can be valid moves:
     * 1. There is at least one empty space on the board.
     * 2. There are two adjacent tiles with the same value.
     */
    public static boolean atLeastOneMoveExists(Board b) {
        // TODO: Fill in this function.
        int[] dx = {0, 1, -1, 0};
        int[] dy = {1, 0, 0, -1};

        int size = b.size();
        for (int i = 0; i < size; i ++ ){
            for (int j = 0; j < size; j ++ ){
                Tile t = b.tile(i, j);
                if (t == null){
                    return true;
                }
                else {
                    for (int k = 0; k < 4; k ++ ){          // Exhaust 4 different directions to find adjacent same tile.
                        int nex = i + dx[k], ney = j + dy[k];
                        if (0 <= nex && nex < size && 0 <= ney && ney < size){ // note that we should not cross the border.
                            Tile ne = b.tile(nex, ney);
                            if (ne!= null && t.value() == ne.value()){
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    /** Returns the model as a string, used for debugging. */
    @Override
    public String toString() {
        Formatter out = new Formatter();
        out.format("%n[%n");
        for (int row = size() - 1; row >= 0; row -= 1) {
            for (int col = 0; col < size(); col += 1) {
                if (tile(col, row) == null) {
                    out.format("|    ");
                } else {
                    out.format("|%4d", tile(col, row).value());
                }
            }
            out.format("|%n");
        }
        String over = gameOver() ? "over" : "not over";
        out.format("] %d (max: %d) (game is %s) %n", score(), maxScore(), over);
        return out.toString();
    }

    /** Returns whether two models are equal. */
    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        } else if (getClass() != o.getClass()) {
            return false;
        } else {
            return toString().equals(o.toString());
        }
    }

    /** Returns hash code of Model’s string. */
    @Override
    public int hashCode() {
        return toString().hashCode();
    }
}
