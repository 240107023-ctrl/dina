public class Task15Adapter implements AuthValidator {
    private final LegacyLdapService ldapService;

    public Task15Adapter(LegacyLdapService ldapService) {
        this.ldapService = ldapService;
    }

    @Override
    public boolean authenticate(AuthCredentials credentials) {
        if (credentials == null) return false;
        return ldapService.checkUserCredentials(credentials.getUsername(), credentials.getPassword());
    }
}