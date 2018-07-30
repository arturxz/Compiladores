/* This file was generated by SableCC (http://www.sablecc.org/). */

package jah.node;

import jah.analysis.*;

@SuppressWarnings("nls")
public final class AUmExpCommLeiaSegundaParte extends PCommLeiaSegundaParte
{
    private PExp _exp_;
    private PCommLeiaTerceiraParte _commLeiaTerceiraParte_;

    public AUmExpCommLeiaSegundaParte()
    {
        // Constructor
    }

    public AUmExpCommLeiaSegundaParte(
        @SuppressWarnings("hiding") PExp _exp_,
        @SuppressWarnings("hiding") PCommLeiaTerceiraParte _commLeiaTerceiraParte_)
    {
        // Constructor
        setExp(_exp_);

        setCommLeiaTerceiraParte(_commLeiaTerceiraParte_);

    }

    @Override
    public Object clone()
    {
        return new AUmExpCommLeiaSegundaParte(
            cloneNode(this._exp_),
            cloneNode(this._commLeiaTerceiraParte_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAUmExpCommLeiaSegundaParte(this);
    }

    public PExp getExp()
    {
        return this._exp_;
    }

    public void setExp(PExp node)
    {
        if(this._exp_ != null)
        {
            this._exp_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._exp_ = node;
    }

    public PCommLeiaTerceiraParte getCommLeiaTerceiraParte()
    {
        return this._commLeiaTerceiraParte_;
    }

    public void setCommLeiaTerceiraParte(PCommLeiaTerceiraParte node)
    {
        if(this._commLeiaTerceiraParte_ != null)
        {
            this._commLeiaTerceiraParte_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._commLeiaTerceiraParte_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._exp_)
            + toString(this._commLeiaTerceiraParte_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._exp_ == child)
        {
            this._exp_ = null;
            return;
        }

        if(this._commLeiaTerceiraParte_ == child)
        {
            this._commLeiaTerceiraParte_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._exp_ == oldChild)
        {
            setExp((PExp) newChild);
            return;
        }

        if(this._commLeiaTerceiraParte_ == oldChild)
        {
            setCommLeiaTerceiraParte((PCommLeiaTerceiraParte) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}