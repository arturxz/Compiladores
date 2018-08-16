/* This file was generated by SableCC (http://www.sablecc.org/). */

package jah.node;

import jah.analysis.*;

@SuppressWarnings("nls")
public final class AUltimoComandoComandos extends PComandos
{
    private PComm _comm_;

    public AUltimoComandoComandos()
    {
        // Constructor
    }

    public AUltimoComandoComandos(
        @SuppressWarnings("hiding") PComm _comm_)
    {
        // Constructor
        setComm(_comm_);

    }

    @Override
    public Object clone()
    {
        return new AUltimoComandoComandos(
            cloneNode(this._comm_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAUltimoComandoComandos(this);
    }

    public PComm getComm()
    {
        return this._comm_;
    }

    public void setComm(PComm node)
    {
        if(this._comm_ != null)
        {
            this._comm_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._comm_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._comm_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._comm_ == child)
        {
            this._comm_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._comm_ == oldChild)
        {
            setComm((PComm) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
