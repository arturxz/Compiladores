/* This file was generated by SableCC (http://www.sablecc.org/). */

package linguagem.node;

import linguagem.analysis.*;

@SuppressWarnings("nls")
public final class TFimBloco extends Token
{
    public TFimBloco()
    {
        super.setText("FIM");
    }

    public TFimBloco(int line, int pos)
    {
        super.setText("FIM");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TFimBloco(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTFimBloco(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TFimBloco text.");
    }
}
