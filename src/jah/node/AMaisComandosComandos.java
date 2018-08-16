/* This file was generated by SableCC (http://www.sablecc.org/). */

package jah.node;

import jah.analysis.*;

@SuppressWarnings("nls")
public final class AMaisComandosComandos extends PComandos
{
    private PComm _comm_;
    private PComandos _comandos_;

    public AMaisComandosComandos()
    {
        // Constructor
    }

    public AMaisComandosComandos(
        @SuppressWarnings("hiding") PComm _comm_,
        @SuppressWarnings("hiding") PComandos _comandos_)
    {
        // Constructor
        setComm(_comm_);

        setComandos(_comandos_);

    }

    @Override
    public Object clone()
    {
        return new AMaisComandosComandos(
            cloneNode(this._comm_),
            cloneNode(this._comandos_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAMaisComandosComandos(this);
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

    public PComandos getComandos()
    {
        return this._comandos_;
    }

    public void setComandos(PComandos node)
    {
        if(this._comandos_ != null)
        {
            this._comandos_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._comandos_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._comm_)
            + toString(this._comandos_);
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

        if(this._comandos_ == child)
        {
            this._comandos_ = null;
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

        if(this._comandos_ == oldChild)
        {
            setComandos((PComandos) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
