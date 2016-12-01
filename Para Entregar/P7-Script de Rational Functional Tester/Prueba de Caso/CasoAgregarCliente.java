
import resources.CasoAgregarClienteHelper;
import com.rational.test.ft.*;
import com.rational.test.ft.object.interfaces.*;
import com.rational.test.ft.object.interfaces.SAP.*;
import com.rational.test.ft.object.interfaces.WPF.*;
import com.rational.test.ft.object.interfaces.dojo.*;
import com.rational.test.ft.object.interfaces.siebel.*;
import com.rational.test.ft.object.interfaces.flex.*;
import com.rational.test.ft.object.interfaces.generichtmlsubdomain.*;
import com.rational.test.ft.script.*;
import com.rational.test.ft.value.*;
import com.rational.test.ft.vp.*;
import com.ibm.rational.test.ft.object.interfaces.sapwebportal.*;
/**
 * Description   : Functional Test Script
 * @author Adriana
 */
public class CasoAgregarCliente extends CasoAgregarClienteHelper
{
	/**
	 * Script Name   : <b>CasoAgregarCliente</b>
	 * Generated     : <b>26/11/2016 20:47:44</b>
	 * Description   : Functional Test Script
	 * Original Host : WinNT Version 6.2  Build 9200 ()
	 * 
	 * @since  2016/11/26
	 * @author Adriana
	 */
	public void testMain(Object[] args) 
	{
		startApp("Proyecto");
		
		// Frame: Login
		empleado().clickToState(SELECTED);
		contraseña().click(atPoint(48,9));
		login().inputKeys("{CAPSLOCK}J{CAPSLOCK}orge{CAPSLOCK}L{CAPSLOCK}opez{TAB}");
		login().inputKeys("{Num1}{Num5}{Num0}{Num3}{Num9}{Num4}");
		entrar().click();
		
		// 
		aceptar().click();
		
		// Frame: Instrumentos
		clientes().click();
		
		// 
		aceptar2().click();
		
		// Frame: Cliente
		jTextField().click(atPoint(53,12));
		cliente().inputKeys("{CAPSLOCK}M{CAPSLOCK}aria {CAPSLOCK}O{CAPSLOCK}rtiz");
		jTextField2().click(atPoint(51,6));
		cliente().inputKeys("{CAPSLOCK}P{CAPSLOCK}eriferico sur {Num7}{Num0}{Num1}{Num5} int ");
		cliente().inputKeys("{Num6}{Num6}");
		jTextField3().click(atPoint(59,9));
		cliente().inputKeys("{Num4}{Num5}{Num5}{Num2}{Num0}");
		jTextField4().click(atPoint(52,10));
		cliente().inputKeys("{CAPSLOCK}OIRM{CAPSLOCK}{Num9}{Num1}{Num1}{Num2}{Num1}{Num2}");
		jTextField5().click(atPoint(51,0));
		cliente().inputKeys("mary{Num2}{Num1}{Num1}{Num2}");
		agregar().click();
		
		// 
		aceptar2().click();
		
		// Frame: Cliente
		mostrar().click();
	}
}

