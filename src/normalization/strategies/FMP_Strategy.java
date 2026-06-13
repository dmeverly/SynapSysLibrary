package normalization.strategies;

import java.net.http.HttpResponse;

public interface FMP_Strategy {
    public String getName();
    public HttpResponse<String> post();
}