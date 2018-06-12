using System.Collections.Generic;
using IdentityServer4;
using IdentityServer4.Models;

namespace FairShare.Server.Identity
{
    public static class Config
    {
        public static IEnumerable<Client> GetClients()
        {
            return new Client[]
            {
                new Client
                {
                    ClientId = "client.android",
                    RequireClientSecret = false,
                    ClientName = "Android app client",
                    AllowedGrantTypes = GrantTypes.Code,
                    RequirePkce = true,
                    RequireConsent = false,

                    RedirectUris = { "org.mokhnatkin.fs://oauth2redirect" },
                    AllowedScopes =
                    {
                        IdentityServerConstants.StandardScopes.OpenId,
                        IdentityServerConstants.StandardScopes.Profile,
                        IdentityServerConstants.StandardScopes.Email,
                        "api1"
                    },
                    AllowOfflineAccess = true
                }
            };
        }
        
        public static IEnumerable<IdentityResource> GetIdentityResources()
        {
            return new List<IdentityResource>
            {
                new IdentityResources.OpenId(),
                new IdentityResources.Email(),
                new IdentityResources.Profile()
            };
        }
        
        public static IEnumerable<ApiResource> GetApis()
        {
            return new[]
            {
                // simple API with a single scope (in this case the scope name is the same as the api name)
                new ApiResource("api1", "Some API 1")
            };
        }
    }
}