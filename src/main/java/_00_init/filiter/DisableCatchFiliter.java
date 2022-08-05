package _00_init.filiter;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class DisableCatchFiliter
 */
@WebFilter(dispatcherTypes = {DispatcherType.REQUEST }
					, urlPatterns = { "/*" })
public class DisableCatchFiliter implements Filter {

    
    public DisableCatchFiliter() {
    }

	
	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, 
			FilterChain chain) throws IOException, ServletException {
		
		if(request instanceof HttpServletRequest 
				&& response instanceof HttpServletResponse) {
		
			HttpServletRequest req= (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		// 通知瀏覽器必須先以 Last-Modified or ETag送出請求來詢問Server，本網頁是否有較新的版本，
		// 如果Server回應沒有，才可以使用快取區內的網頁，否則必須再次送出請求取得更新的版本
		resp.setHeader("Cache-Control", "no-cache");
		
		// 通知瀏覽器絕對不要將本網頁儲存在快取區內
		resp.setHeader("Cache-Control", "no-store");
		
		// Causes the proxy cache to see the page as "stale",
					// 0 表示該網頁的有效期限為  1970/01/01 00:00:00 GMT，若現在時間超過它，就不能再使用
					// 快取出內的網頁
		resp.setDateHeader("Expires", 0);
		
		// 為了與 HTTP 1.0 相容，加入此回應標頭 
		resp.setHeader("Pragma", "no-cache");
		chain.doFilter(req, resp);
		}
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
