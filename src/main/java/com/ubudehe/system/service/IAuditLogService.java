package com.ubudehe.system.service;

import com.ubudehe.system.model.AuditLog;
import com.ubudehe.system.model.Category;

import java.util.List;

public interface IAuditLogService {
    AuditLog addAuditLog(AuditLog auditLog);

    List<AuditLog> getAllAuditLogs();


    AuditLog getAuditLogById(Long id);

}
