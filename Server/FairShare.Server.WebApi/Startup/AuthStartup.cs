using FairShare.Server.WebApi.Users;
using JetBrains.Annotations;
using Microsoft.AspNetCore.Authentication.JwtBearer;
using Microsoft.AspNetCore.Builder;
using Microsoft.AspNetCore.Hosting;
using Microsoft.AspNetCore.Identity;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.DependencyInjection;

namespace FairShare.Server.WebApi.Startup
{
    public static class AuthStartup
    {
        public static void ConfigureServices(IServiceCollection services, [NotNull] IConfiguration configuration)
        {
            services.AddIdentity<ApplicationUser, IdentityRole>()
                .AddEntityFrameworkStores<ApplicationDbContext>()
                .AddDefaultTokenProviders();

            services.AddAuthentication(JwtBearerDefaults.AuthenticationScheme)
                .AddGoogle(options =>
                {
                    options.ClientId = configuration["Auth:Google:ClientId"];
                    options.ClientSecret = configuration["Auth:Google:ClientSecret"];
                });
        }
        
        public static void Configure(IApplicationBuilder app, IHostingEnvironment env)
        {
            app.UseAuthentication();
        }
    }
}