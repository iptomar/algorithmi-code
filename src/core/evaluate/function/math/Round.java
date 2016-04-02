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
package core.evaluate.function.math;

import core.data.FabstractNumber;
import core.data.Finteger;
import core.data.Freal;
import core.data.Fsymbol;
import core.data.exception.FlowchartException;
import core.evaluate.CoreElement;
import core.parser.Mark;
import i18n.FkeyWord;
import i18n.FkeywordToken;
import java.util.ArrayList;
import java.util.Locale;

/**
 * Created on 7/set/2015, 11:19:08
 *
 * @author Antonio M@nso <manso@ipt.pt>
 */
public class Round extends CoreElement {

    public static String symbol = FkeyWord.get("FUNCTION.round");
    public static String help = FkeyWord.get("FUNCTION.round.help");
    public static String definition = FkeyWord.get("FUNCTION.round.definition");

    public Round() {
        super(2, PRIORITY_FUNCTION);
    }

    @Override
    public String getSymbol() {
        return symbol;
    }

    @Override
    public String getHelp() {
        return help;
    }

    @Override
    public String getDifinition() {
        return definition;
    }

    @Override
    protected Fsymbol execute(Fsymbol[] p) throws FlowchartException {
        double p0 = ((FabstractNumber) p[0]).getDoubleValue();
        int p1 = ((Finteger) p[1]).getIntValue();
        String res = String.format(Locale.US, "%." + p1 + "f%n", p0);
        return new Freal(Double.parseDouble(res));
    }

    @Override
    protected Fsymbol returnType(Fsymbol[] p) throws FlowchartException {
        //--------------------------------------------------------------------
        //verify the position of the parameters in the expression
        //  function p[0] p[1]
        //--------------------------------------------------------------------
        if (p[0].ID < ID || p[1].ID < p[0].ID) {
            //:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::        
            //::::::::::::::::::::: FLOWCHART EXCEPTION ERROR :::::::::::::::::::::::::
            //:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
            throw new FlowchartException("TOKEN.error.wrongParams");
        }
        //------------------------------------------------------------------------

        if (p[0] instanceof FabstractNumber && p[1] instanceof Finteger) {
            return new Freal(1);
        }

        //:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::        
        //::::::::::::::::::::: FLOWCHART EXCEPTION ERROR :::::::::::::::::::::::::
        //:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
        throw new FlowchartException("FUNCTION.error.typeParams",
                getSymbol(),
                getSymbol() + Mark.ROUND_OPEN + p[0].getTypeName() + Mark.COMMA_CHAR + p[1].getTypeName() + Mark.ROUND_CLOSE,
                getSymbol() + Mark.ROUND_OPEN + p[0].getDefinitionValue() + Mark.COMMA_CHAR + p[1].getDefinitionValue() + Mark.ROUND_CLOSE
        );
    }

    public static void main(String[] args) {
        Round calc = new Round();
        try {
            ArrayList<Fsymbol> lst = new ArrayList<>();
            // lst.add(new Freal(-246122.1234567890));
            lst.add(new Finteger(4));
            lst.add(new Finteger(4));
//            lst.add( new Finteger(3));
//            lst.add(new Text("\"ola\""));
//            lst.add(new Text("\" mundo\""));
//            lst.add(new Flogic(true));            

            Fsymbol res = calc.evaluate(lst);
            System.out.println(res);

        } catch (FlowchartException ex) {
            ex.show("Test " + calc.getClass());
        }
    }
    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    //TOKEN OF CALCULATOR
    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    public static String TOKEN = FkeywordToken.get("FUNCTION.round.key");

    @Override
    public String getTokenID() {
        return TOKEN;
    }
   //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    private static final long serialVersionUID = 201509071200L;
    //:::::::::::::::::::::::::::  Copyright(c) M@nso  2015  :::::::::::::::::::
    ///////////////////////////////////////////////////////////////////////////
}