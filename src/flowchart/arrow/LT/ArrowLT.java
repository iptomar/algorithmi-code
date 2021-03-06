/*
 * Copyright (c) 2015 Instituto Politecnico de Tomar. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 */
//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: 
//::                                                                         ::
//::     Antonio Manuel Rodrigues Manso                                      ::
//::                                                                         ::
//::     I N S T I T U T O    P O L I T E C N I C O   D E   T O M A R        ::
//::     Escola Superior de Tecnologia de Tomar                              ::
//::     e-mail: manso@ipt.pt                                                ::
//::     url   : http://orion.ipt.pt/~manso                                  ::
//::                                                                         ::
//::     This software was build with the purpose of investigate and         ::
//::     learning.                                                           ::
//::                                                                         ::
//::                                                               (c)2015   ::
//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
//////////////////////////////////////////////////////////////////////////////

package flowchart.arrow.LT;

import core.data.exception.FlowchartException;
import ui.FProperties;
import flowchart.arrow.Arrow;
import flowchart.shape.BorderFlowChart;
import flowchart.shape.Fshape;
import java.awt.Dimension;

/**
 *
 * @author ZULU
 */
public final class ArrowLT extends Arrow {

    public ArrowLT(Fshape begin, Fshape end) {
        super(new ShapeArrowLT(FProperties.arrowColor), begin, end);
        setLink(begin, end);
    }

    public void setLink(Fshape begin, Fshape end) {
        begin.left = this;
        end.parent = this;

        this.level = begin.level + 1;
        this.parent = begin;
        this.next = end;
    }

    @Override
    public void updatePosition() {
        int x0 = next.getX() +  next.getWidth() / 2 - BorderFlowChart.getThickness() / 2 -  BorderFlowChart.getThickness();
        int y0 = parent.getY() + parent.getHeight() / 2 - BorderFlowChart.getThickness() / 2;

        setLocation(x0, y0);
    }

    protected Dimension getPreferedDimension() {
        if (parent != null && next != null) {
            int w = parent.getX() - next.getX() - next.getWidth() / 2 + BorderFlowChart.getThickness()/2 +  (BorderFlowChart.getThickness());
            int h = next.getY() - parent.getY() - parent.getHeight() / 2 + BorderFlowChart.getThickness() / 2;

            return new Dimension(w, h);

        } else {
            return super.getPreferedDimension();
        }
    }

    @Override
    public boolean parseShape() throws FlowchartException {
        return true;
    }
    
    

    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    private static final long serialVersionUID = 201509071215L;
    //:::::::::::::::::::::::::::  Copyright(c) M@nso  2015  :::::::::::::::::::
    ///////////////////////////////////////////////////////////////////////////
}
