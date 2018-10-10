import org.junit.Test;
import static org.junit.Assert.*; 

public class CalcTest
{
   @Test public void testAdd()
   {
       assertTrue ("Calc sum incorrect", 5 == Calc.add (2, 3));
   }
}

