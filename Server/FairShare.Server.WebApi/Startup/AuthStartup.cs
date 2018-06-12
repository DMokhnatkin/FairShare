using JetBrains.Annotations;
using Microsoft.AspNetCore.Builder;
using Microsoft.AspNetCore.Hosting;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.DependencyInjection;

namespace FairShare.Server.WebApi.Startup
{
    public static class AuthStartup
    {
        public static void ConfigureServices(IServiceCollection services, [NotNull] IConfiguration configuration)
        {
            
        }
        
        public static void Configure(IApplicationBuilder app, IHostingEnvironment env)
        {
            
        }
    }
}