using System;
using IdentityServer4;
using JetBrains.Annotations;
using Microsoft.AspNetCore.Builder;
using Microsoft.AspNetCore.Hosting;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.DependencyInjection;

namespace FairShare.Server.Identity.Startup
{
    public static class IdentityServerStartup
    {
        public static void ConfigureServices(IServiceCollection services, [NotNull] IConfiguration configuration)
        {
            services.AddIdentityServer()
                .AddInMemoryClients(Config.GetClients())
                .AddInMemoryIdentityResources(Config.GetIdentityResources())
                .AddInMemoryApiResources(Config.GetApis())
                .AddDeveloperSigningCredential();
            services.AddAuthentication()
                .AddGoogle("Google", options =>
                {
                    options.SignInScheme = IdentityServerConstants.ExternalCookieAuthenticationScheme;
                    options.ClientId = configuration["Auth:GoogleClientId"] ?? throw new ArgumentException("Google client id was not specified.");
                    options.ClientSecret = configuration["Auth:GoogleClientSecret"] ?? throw new ArgumentException("Google client secret was not specified.");
                });
        }

        public static void Configure(IApplicationBuilder app, IHostingEnvironment env)
        {
            app.UseIdentityServer();
        }
    }
}