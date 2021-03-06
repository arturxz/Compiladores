/* This file was generated by SableCC (http://www.sablecc.org/). */

package jah.node;

import jah.analysis.*;

@SuppressWarnings("nls")
public final class ASingleDecls extends PDecls
{
    private PDecl _decl_;

    public ASingleDecls()
    {
        // Constructor
    }

    public ASingleDecls(
        @SuppressWarnings("hiding") PDecl _decl_)
    {
        // Constructor
        setDecl(_decl_);

    }

    @Override
    public Object clone()
    {
        return new ASingleDecls(
            cloneNode(this._decl_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseASingleDecls(this);
    }

    public PDecl getDecl()
    {
        return this._decl_;
    }

    public void setDecl(PDecl node)
    {
        if(this._decl_ != null)
        {
            this._decl_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._decl_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._decl_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._decl_ == child)
        {
            this._decl_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._decl_ == oldChild)
        {
            setDecl((PDecl) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
