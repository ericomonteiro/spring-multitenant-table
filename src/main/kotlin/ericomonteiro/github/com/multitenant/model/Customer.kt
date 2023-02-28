package ericomonteiro.github.com.multitenant.model

import ericomonteiro.github.com.multitenant.config.TenantContext
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import org.hibernate.annotations.TenantId

@Entity
class Customer (
    @Id @Column(length = 36)
    val id: String,
    val name: String,
    val email: String
) {

    @TenantId
    private val tenantId: String = TenantContext.currentTenant
}