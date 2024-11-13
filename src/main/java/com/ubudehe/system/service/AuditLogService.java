package com.ubudehe.system.service;

import com.ubudehe.system.exception.CategoryNotFoundException;
import com.ubudehe.system.model.AuditLog;
import com.ubudehe.system.model.Category;
import com.ubudehe.system.repository.AuditLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuditLogService implements IAuditLogService {

    private final AuditLogRepository auditLogRepository;

    @Override
    public List<AuditLog> getAllAuditLogs() {
        return auditLogRepository.findAll();
    }

    @Override
    public AuditLog addAuditLog(AuditLog auditLog) {
        return auditLogRepository.save(auditLog);
    }


    @Override
    public AuditLog getAuditLogById(Long id) {
        return null;
    }
}
