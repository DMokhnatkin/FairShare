using System.Data.SqlClient;
using System.Net;
using JetBrains.Annotations;
using Microsoft.AspNetCore.Builder;
using Microsoft.AspNetCore.Hosting;
using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.DependencyInjection;

namespace FairShare.Server.WebApi.Startup
{
    public static class DbStartup
    {
        public static void ConfigureServices(IServiceCollection services, [NotNull] IConfiguration configuration)
        {
            services.AddDbContext<ApplicationDbContext>(options => 
                options.UseNpgsql(configuration["Db:ConnectionString"]));
        }
        
        public static void Configure(IApplicationBuilder app, IHostingEnvironment env)
        {
            
        }
    }
}