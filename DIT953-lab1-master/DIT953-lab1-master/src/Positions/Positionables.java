package Positions;

import java.awt.image.DirectColorModel;
import java.util.Arrays;
import java.util.List;

public abstract class Positionables {
    private double xPos; // The X position
    private double yPos; // The Y position
    private Direction direction;

    public Positionables(int xPos, int yPos, Direction direction){
        this.xPos = xPos;
        this.yPos = yPos;
        this.direction = direction;
    }
    double getxPos() { return xPos; }

    double getyPos() { return yPos; }

    void setxPos(double xPos) { this.xPos = xPos; }

    void setyPos(double yPos) { this.yPos = yPos; }

//    List<DumbAssKangarooPackage.Direction> getDirectionList() {
//        return direction;
//    }

    Direction getDirection() {return direction; }

    public void setDirection(Direction direction){
        this.direction = direction;
        /*while(getDirection() != direction){
            turnRight();
        }*/
    }
}
