/* This file was generated by SableCC (http://www.sablecc.org/). */

package jah.node;

import jah.analysis.*;

@SuppressWarnings("nls")
public final class ACommLeia extends PCommLeia
{
    private TLeia _leia_;
    private TAbreParentesis _abreParentesis_;
    private PCommLeiaSegundaParte _commLeiaSegundaParte_;

    public ACommLeia()
    {
        // Constructor
    }

    public ACommLeia(
        @SuppressWarnings("hiding") TLeia _leia_,
        @SuppressWarnings("hiding") TAbreParentesis _abreParentesis_,
        @SuppressWarnings("hiding") PCommLeiaSegundaParte _commLeiaSegundaParte_)
    {
        // Constructor
        setLeia(_leia_);

        setAbreParentesis(_abreParentesis_);

        setCommLeiaSegundaParte(_commLeiaSegundaParte_);

    }

    @Override
    public Object clone()
    {
        return new ACommLeia(
            cloneNode(this._leia_),
            cloneNode(this._abreParentesis_),
            cloneNode(this._commLeiaSegundaParte_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseACommLeia(this);
    }

    public TLeia getLeia()
    {
        return this._leia_;
    }

    public void setLeia(TLeia node)
    {
        if(this._leia_ != null)
        {
            this._leia_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._leia_ = node;
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

    public PCommLeiaSegundaParte getCommLeiaSegundaParte()
    {
        return this._commLeiaSegundaParte_;
    }

    public void setCommLeiaSegundaParte(PCommLeiaSegundaParte node)
    {
        if(this._commLeiaSegundaParte_ != null)
        {
            this._commLeiaSegundaParte_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._commLeiaSegundaParte_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._leia_)
            + toString(this._abreParentesis_)
            + toString(this._commLeiaSegundaParte_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._leia_ == child)
        {
            this._leia_ = null;
            return;
        }

        if(this._abreParentesis_ == child)
        {
            this._abreParentesis_ = null;
            return;
        }

        if(this._commLeiaSegundaParte_ == child)
        {
            this._commLeiaSegundaParte_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._leia_ == oldChild)
        {
            setLeia((TLeia) newChild);
            return;
        }

        if(this._abreParentesis_ == oldChild)
        {
            setAbreParentesis((TAbreParentesis) newChild);
            return;
        }

        if(this._commLeiaSegundaParte_ == oldChild)
        {
            setCommLeiaSegundaParte((PCommLeiaSegundaParte) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
