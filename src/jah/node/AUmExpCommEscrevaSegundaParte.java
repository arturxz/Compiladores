/* This file was generated by SableCC (http://www.sablecc.org/). */

package jah.node;

import jah.analysis.*;

@SuppressWarnings("nls")
public final class AUmExpCommEscrevaSegundaParte extends PCommEscrevaSegundaParte
{
    private PExpOuExpLogica _expOuExpLogica_;
    private PCommEscrevaTerceiraParte _commEscrevaTerceiraParte_;

    public AUmExpCommEscrevaSegundaParte()
    {
        // Constructor
    }

    public AUmExpCommEscrevaSegundaParte(
        @SuppressWarnings("hiding") PExpOuExpLogica _expOuExpLogica_,
        @SuppressWarnings("hiding") PCommEscrevaTerceiraParte _commEscrevaTerceiraParte_)
    {
        // Constructor
        setExpOuExpLogica(_expOuExpLogica_);

        setCommEscrevaTerceiraParte(_commEscrevaTerceiraParte_);

    }

    @Override
    public Object clone()
    {
        return new AUmExpCommEscrevaSegundaParte(
            cloneNode(this._expOuExpLogica_),
            cloneNode(this._commEscrevaTerceiraParte_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAUmExpCommEscrevaSegundaParte(this);
    }

    public PExpOuExpLogica getExpOuExpLogica()
    {
        return this._expOuExpLogica_;
    }

    public void setExpOuExpLogica(PExpOuExpLogica node)
    {
        if(this._expOuExpLogica_ != null)
        {
            this._expOuExpLogica_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._expOuExpLogica_ = node;
    }

    public PCommEscrevaTerceiraParte getCommEscrevaTerceiraParte()
    {
        return this._commEscrevaTerceiraParte_;
    }

    public void setCommEscrevaTerceiraParte(PCommEscrevaTerceiraParte node)
    {
        if(this._commEscrevaTerceiraParte_ != null)
        {
            this._commEscrevaTerceiraParte_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._commEscrevaTerceiraParte_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._expOuExpLogica_)
            + toString(this._commEscrevaTerceiraParte_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._expOuExpLogica_ == child)
        {
            this._expOuExpLogica_ = null;
            return;
        }

        if(this._commEscrevaTerceiraParte_ == child)
        {
            this._commEscrevaTerceiraParte_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._expOuExpLogica_ == oldChild)
        {
            setExpOuExpLogica((PExpOuExpLogica) newChild);
            return;
        }

        if(this._commEscrevaTerceiraParte_ == oldChild)
        {
            setCommEscrevaTerceiraParte((PCommEscrevaTerceiraParte) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
