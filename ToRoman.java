package cs3220.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ToRoman extends SimpleTagSupport {

	int value;
	
	public ToRoman() {
		
	}
	
	public void setValue(int value) {
		
		this.value = value;
	}
	
	@Override
	public void doTag() throws JspException, IOException {
		
		JspWriter out = getJspContext().getOut();
		
		int num = value;
		
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        
        String[] romanLiterals = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder roman = new StringBuilder();

        for(int i=0;i<values.length;i++) 
        {
            while(num >= values[i]) 
            {
                num -= values[i];
                roman.append(romanLiterals[i]);
            }
        }
        
        out.print(roman.toString());
	}

}
