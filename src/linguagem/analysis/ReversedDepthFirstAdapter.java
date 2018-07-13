/* This file was generated by SableCC (http://www.sablecc.org/). */

package linguagem.analysis;

import java.util.*;
import linguagem.node.*;

public class ReversedDepthFirstAdapter extends AnalysisAdapter
{
    public void inStart(Start node)
    {
        defaultIn(node);
    }

    public void outStart(Start node)
    {
        defaultOut(node);
    }

    public void defaultIn(@SuppressWarnings("unused") Node node)
    {
        // Do nothing
    }

    public void defaultOut(@SuppressWarnings("unused") Node node)
    {
        // Do nothing
    }

    @Override
    public void caseStart(Start node)
    {
        inStart(node);
        node.getEOF().apply(this);
        node.getPCabecalho().apply(this);
        outStart(node);
    }

    public void inACabecalho(ACabecalho node)
    {
        defaultIn(node);
    }

    public void outACabecalho(ACabecalho node)
    {
        defaultOut(node);
    }

    @Override
    public void caseACabecalho(ACabecalho node)
    {
        inACabecalho(node);
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        if(node.getPrograma() != null)
        {
            node.getPrograma().apply(this);
        }
        outACabecalho(node);
    }
}
