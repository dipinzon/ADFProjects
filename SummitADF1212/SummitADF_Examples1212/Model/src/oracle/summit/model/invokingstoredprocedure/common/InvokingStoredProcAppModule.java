package oracle.summit.model.invokingstoredprocedure.common;

import oracle.jbo.ApplicationModule;
import oracle.jbo.domain.Date;

import oracle.summit.model.invokingstoredprocedure.DateAndStringBean;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Mon Mar 18 14:31:56 CDT 2013
// ---------------------------------------------------------------------
public interface InvokingStoredProcAppModule extends ApplicationModule {
    String callFuncWithThreeArgs(oracle.jbo.domain.Number n, Date d, String v);

    void callProcWithNoArgs();

    DateAndStringBean callProcWithOutArgs(oracle.jbo.domain.Number n, String v);

    void callProcWithThreeArgs(oracle.jbo.domain.Number n, Date d, String v);
}

