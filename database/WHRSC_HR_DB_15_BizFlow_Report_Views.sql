CREATE VIEW VW_BIZFLOW_ACTION_OWNER
AS
SELECT  A.NAME as PROCESS_NAME,
        FN_GET_RLVNTDATAVALUE(A.PROCID, 'I', 'S', 'transactionNumber') as TRANSACTION_NUMBER,
        FN_GET_RLVNTDATAVALUE(A.PROCID, 'I', 'S', 'requisitionNumber') as REQUISITION_NUMBER,           
        B.NAME ACTIVITY_NAME, 
        C.WITEMSEQ AS WORKLIST_ID, 
        C.CREATIONDTIME AS CREATED_DATE,
        C.PRTCPNAME AS PARTICIPANT
FROM  ACT B,
      WITEM C,  
      PROCS A
WHERE  A.SVRID = C.SVRID
       AND A.PROCID = C.PROCID
       AND A.STATE = 'R'
       AND A.NAME IN ('WHRSC Appointment','WHRSC Recruitment')
       AND B.PROCID = C.PROCID
       AND B.ACTSEQ = C.ACTSEQ
       AND C.STATE IN ('I','R','P','V');