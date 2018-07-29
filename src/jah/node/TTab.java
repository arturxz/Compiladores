/* This file was generated by SableCC (http://www.sablecc.org/). */

package jah.node;

import jah.analysis.*;

@SuppressWarnings("nls")
public final class TTab extends Token
{
    public TTab()
    {
        super.setText("\t");
    }

    public TTab(int line, int pos)
    {
        super.setText("\t");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TTab(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTTab(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TTab text.");
    }
}
