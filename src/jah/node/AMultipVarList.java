/* This file was generated by SableCC (http://www.sablecc.org/). */

package jah.node;

import jah.analysis.*;

@SuppressWarnings("nls")
public final class AMultipVarList extends PVarList
{
    private PVar _var_;
    private PVarList _varList_;

    public AMultipVarList()
    {
        // Constructor
    }

    public AMultipVarList(
        @SuppressWarnings("hiding") PVar _var_,
        @SuppressWarnings("hiding") PVarList _varList_)
    {
        // Constructor
        setVar(_var_);

        setVarList(_varList_);

    }

    @Override
    public Object clone()
    {
        return new AMultipVarList(
            cloneNode(this._var_),
            cloneNode(this._varList_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAMultipVarList(this);
    }

    public PVar getVar()
    {
        return this._var_;
    }

    public void setVar(PVar node)
    {
        if(this._var_ != null)
        {
            this._var_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._var_ = node;
    }

    public PVarList getVarList()
    {
        return this._varList_;
    }

    public void setVarList(PVarList node)
    {
        if(this._varList_ != null)
        {
            this._varList_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._varList_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._var_)
            + toString(this._varList_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._var_ == child)
        {
            this._var_ = null;
            return;
        }

        if(this._varList_ == child)
        {
            this._varList_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._var_ == oldChild)
        {
            setVar((PVar) newChild);
            return;
        }

        if(this._varList_ == oldChild)
        {
            setVarList((PVarList) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
