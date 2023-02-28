package ericomonteiro.github.com.multitenant.config.tenant

import org.hibernate.cfg.AvailableSettings
import org.hibernate.context.spi.CurrentTenantIdentifierResolver
import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer
import org.springframework.stereotype.Component


@Component
class TenantIdentifierResolver: CurrentTenantIdentifierResolver,
    HibernatePropertiesCustomizer {
    override fun resolveCurrentTenantIdentifier(): String {
        return TenantContext.currentTenant
    }

    override fun validateExistingCurrentSessions(): Boolean = true

    override fun customize(hibernateProperties: MutableMap<String, Any>) {
        hibernateProperties[AvailableSettings.MULTI_TENANT_IDENTIFIER_RESOLVER] = this;
    }

}