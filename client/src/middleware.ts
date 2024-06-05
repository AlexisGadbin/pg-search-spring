import createMiddleware from 'next-intl/middleware'

export type Locales = 'en' | 'fr'

export const locales: Locales[] = ['en', 'fr']

export default createMiddleware({
  locales: locales,

  defaultLocale: 'en',
})

export const config = {
  matcher: ['/', '/(fr|en)/:path*'],
}
