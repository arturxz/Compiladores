/* This file was generated by SableCC (http://www.sablecc.org/). */

package jah.node;

import jah.analysis.*;

@SuppressWarnings("nls")
public final class ACommEscreva extends PCommEscreva
{
    private TEscreva _escreva_;
    private TAbreParentesis _abreParentesis_;
    private PCommEscrevaSegundaParte _commEscrevaSegundaParte_;

    public ACommEscreva()
    {
        // Constructor
    }

    public ACommEscreva(
        @SuppressWarnings("hiding") TEscreva _escreva_,
        @SuppressWarnings("hiding") TAbreParentesis _abreParentesis_,
        @SuppressWarnings("hiding") PCommEscrevaSegundaParte _commEscrevaSegundaParte_)
    {
        // Constructor
        setEscreva(_escreva_);

        setAbreParentesis(_abreParentesis_);

        setCommEscrevaSegundaParte(_commEscrevaSegundaParte_);

    }

    @Override
    public Object clone()
    {
        return new ACommEscreva(
            cloneNode(this._escreva_),
            cloneNode(this._abreParentesis_),
            cloneNode(this._commEscrevaSegundaParte_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseACommEscreva(this);
    }

    public TEscreva getEscreva()
    {
        return this._escreva_;
    }

    public void setEscreva(TEscreva node)
    {
        if(this._escreva_ != null)
        {
            this._escreva_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._escreva_ = node;
    }

    public TAbreParentesis getAbreParentesis()
    {
        return this._abreParentesis_;
    }

    public void setAbreParentesis(TAbreParentesis node)
    {
        if(this._abreParentesis_ != null)
        {
            this._abreParentesis_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._abreParentesis_ = node;
    }

    public PCommEscrevaSegundaParte getCommEscrevaSegundaParte()
    {
        return this._commEscrevaSegundaParte_;
    }

    public void setCommEscrevaSegundaParte(PCommEscrevaSegundaParte node)
    {
        if(this._commEscrevaSegundaParte_ != null)
        {
            this._commEscrevaSegundaParte_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._commEscrevaSegundaParte_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._escreva_)
            + toString(this._abreParentesis_)
            + toString(this._commEscrevaSegundaParte_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._escreva_ == child)
        {
            this._escreva_ = null;
            return;
        }

        if(this._abreParentesis_ == child)
        {
            this._abreParentesis_ = null;
            return;
        }

        if(this._commEscrevaSegundaParte_ == child)
        {
            this._commEscrevaSegundaParte_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._escreva_ == oldChild)
        {
            setEscreva((TEscreva) newChild);
            return;
        }

        if(this._abreParentesis_ == oldChild)
        {
            setAbreParentesis((TAbreParentesis) newChild);
            return;
        }

        if(this._commEscrevaSegundaParte_ == oldChild)
        {
            setCommEscrevaSegundaParte((PCommEscrevaSegundaParte) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}