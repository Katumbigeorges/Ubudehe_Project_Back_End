package com.ubudehe.system.controller;

import com.ubudehe.system.model.AuditLog;
import com.ubudehe.system.service.IAuditLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/audit-log")
@RequiredArgsConstructor
public class AuditLogController {
    private final IAuditLogService auditLogService;

    @GetMapping
    public ResponseEntity<List<AuditLog>> getAuditLog(){
        return new ResponseEntity<>(auditLogService.getAllAuditLogs(), HttpStatus.FOUND);
    }

    @PostMapping
    public AuditLog addAuditLog(@RequestBody AuditLog auditLog){
        return auditLogService.addAuditLog(auditLog);
    }

    @GetMapping("/audit-log/{id}")
    public AuditLog getAuditLogById(@PathVariable Long id){
        return auditLogService.getAuditLogById(id);
    }
}
