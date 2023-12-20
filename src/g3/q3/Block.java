package g3.q3;

import java.util.ArrayList;
import java.util.List;

public class Block {

  private final List<Block> neighbors;
  private char value;
  private boolean visited;

  public Block(char value) {
    this.value = value;
    neighbors = new ArrayList<>();
  }

  public char getValue() {
    return value;
  }

  public void setValue(char value) {
    this.value = value;
  }

  public boolean isVisited() {
    return visited;
  }

  public void setVisited(boolean visited) {
    this.visited = visited;
  }

  public void addNeighbor(Block neighbor) {
    neighbors.add(neighbor);
  }

  public boolean isNeighbor(Block block) {
    return neighbors.contains(block);
  }

}
