package juke.swing.layouts;

import java.awt.*;

public abstract class Layout implements LayoutManager
{
    private int leftIndent = 0;
    private int rightIndent = 0;
    private int topIndent = 0;
    private int bottomIndent = 0;

    public void setIndents(int leftIndent, int topIndent, int rightIndent, int bottomIndent)
    {
        this.setLeftIndent(leftIndent);
        this.setTopIndent(topIndent);
        this.setRightIndent(rightIndent);
        this.setBottomIndent(bottomIndent);
    }

    @Override
    public void addLayoutComponent(String name, Component comp){}

    @Override
    public void removeLayoutComponent(Component comp){}

    @Override
    public Dimension preferredLayoutSize(Container parent)
    {
        return minimumLayoutSize(parent);
    }

    @Override
    public abstract Dimension minimumLayoutSize(Container parent);

    @Override
    public abstract void layoutContainer(Container parent);

    public int getLeftIndent()
    {
        return leftIndent;
    }

    public void setLeftIndent(int leftIndent)
    {
        this.leftIndent = leftIndent;
    }

    public int getRightIndent()
    {
        return rightIndent;
    }

    public void setRightIndent(int rightIndent)
    {
        this.rightIndent = rightIndent;
    }

    public int getTopIndent()
    {
        return topIndent;
    }

    public void setTopIndent(int topIndent)
    {
        this.topIndent = topIndent;
    }

    public int getBottomIndent()
    {
        return bottomIndent;
    }

    public void setBottomIndent(int bottomIndent)
    {
        this.bottomIndent = bottomIndent;
    }

}
