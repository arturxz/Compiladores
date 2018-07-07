/* This file was generated by SableCC (http://www.sablecc.org/). */

package linguagem.node;

import linguagem.analysis.*;

@SuppressWarnings("nls")
public final class TEspaco extends Token
{
    public TEspaco()
    {
        super.setText(" ");
    }

    public TEspaco(int line, int pos)
    {
        super.setText(" ");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TEspaco(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTEspaco(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TEspaco text.");
    }
}
