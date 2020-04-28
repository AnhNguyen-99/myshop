package com.myshop.pagination;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class PaginationTagHander extends SimpleTagSupport {

	private String uri;
	private int offset;
	private int count;
	private int steps;
	private String next;
	private String previous;

	@Override
	public void doTag() throws JspException {
		JspWriter out = getJspContext().getOut();

		try {
			JspFragment f = getJspBody();
			if (f != null) {
				f.invoke(out);
			}

			out.write("<nav>");
			out.write("<ul class=\"pagination\">");
			if (offset < steps) {
				out.write(constructLink(1, previous, "disabled", true));
			} else {
				out.write(constructLink(offset - steps, previous, null, false));
			}

			for (int index = 0; index < count; index += steps) {
				if (index == offset) {
					out.write(constructLink(index, String.valueOf(index / steps + 1), "active", true));
				} else {
					out.write(constructLink(index, String.valueOf(index / steps + 1), null, false));
				}
			}

			if (offset + steps >= count) {
				out.write(constructLink(offset + steps, next, "disabled", true));
			} else {
				out.write(constructLink(offset + steps, next, null, false));
			}
			out.write("</ul>");
			out.write("</nav>");
		} catch (java.io.IOException ex) {
			throw new JspException("Error in PaginationTagHander tag", ex);
		}
	}
	
	
	public String getUri() {
		return uri;
	}


	public void setUri(String uri) {
		this.uri = uri;
	}


	public int getOffset() {
		return offset;
	}


	public void setOffset(int offset) {
		this.offset = offset;
	}


	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}


	public int getSteps() {
		return steps;
	}


	public void setSteps(int steps) {
		this.steps = steps;
	}


	public String getNext() {
		return next;
	}


	public void setNext(String next) {
		this.next = next;
	}


	public String getPrevious() {
		return previous;
	}


	public void setPrevious(String previous) {
		this.previous = previous;
	}


	private String constructLink(int page, String text, String className, boolean disable) {
        StringBuilder str = new StringBuilder("<li");
        if (className != null) {
            str.append(" class=\"").append(className).append("\"");
        }
        if (disable) {
            str.append("><a href=\"#\">").append(text).append("</a></li>");
        } else {
            str.append("><a href=\"").append(uri).append("?offset=").append(page).append("\">").append(text).append("</a></li>");
        }
        return str.toString();
    }
	
	
}
